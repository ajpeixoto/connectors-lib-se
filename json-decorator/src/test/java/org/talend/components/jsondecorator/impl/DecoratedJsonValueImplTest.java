package org.talend.components.jsondecorator.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.talend.components.jsondecorator.api.DecoratedJsonValue;
import org.talend.components.jsondecorator.api.JsonDecoratorBuilder;

import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonPatch;
import javax.json.JsonValue;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

class DecoratedJsonValueImplTest {

    @Test
    public void basic() {
        JsonValue json = TestUtil.loadJson("/json/geologistsComplex.json");

        JsonDecoratorBuilder builder = JsonDecoratorFactoryImpl.getInstance().createBuilder();
        DecoratedJsonValue decoratedJsonValue = builder.build(json);

        JsonValue content_length = decoratedJsonValue.asJsonObject().get("content_length");

        Assertions.assertEquals(JsonValue.ValueType.OBJECT, decoratedJsonValue.getValueType());
        Assertions.assertEquals(JsonValue.ValueType.NUMBER, content_length.getValueType());
        Assertions.assertEquals(json.asJsonObject().getJsonNumber("content_length").isIntegral(), JsonNumber.class.cast(content_length).isIntegral());
        Assertions.assertEquals(5, JsonNumber.class.cast(content_length).intValue());

        JsonPatch diff = Json.createDiff(json.asJsonObject(), decoratedJsonValue.asJsonObject());
        Assertions.assertEquals(0, diff.toJsonArray().size());
    }

    @Test
    public void forceTypes() throws IOException {
        JsonValue json = TestUtil.loadJson("/json/geologistsComplex.json");

        JsonDecoratorBuilder builder = JsonDecoratorFactoryImpl.getInstance().createBuilder();
        DecoratedJsonValue decoratedJsonValue = builder
                .cast("/content_length", JsonDecoratorBuilder.ValueTypeExtended.FLOAT)
                .cast("/content/age", JsonDecoratorBuilder.ValueTypeExtended.FLOAT)
                .cast("/content/address/zipcode", JsonDecoratorBuilder.ValueTypeExtended.FLOAT)
                .cast("/content/tel", JsonDecoratorBuilder.ValueTypeExtended.INT)
                .cast("/content/bag", JsonDecoratorBuilder.ValueTypeExtended.STRING)
                .build(json);

        JsonPatch diff = Json.createDiff(json.asJsonObject(), decoratedJsonValue.asJsonObject());
        if(true) {
            // Display the diff
            diff.toJsonArray().stream().forEach(d -> System.out.println(String.format("%s=%s", d.asJsonObject().getString("path"), d.toString())));
        }
        Assertions.assertEquals(47, diff.toJsonArray().size());

        Map<String, JsonValue> diffMap = diff.toJsonArray().stream().collect(Collectors.toMap(j -> j.asJsonObject().getString("path").toString(), j -> j));

        Properties prop = TestUtil.loadProperties("/diff/forceTypes.properties");
        prop.forEach((k, v) -> Assertions.assertEquals(v, diffMap.get(k).toString()));

    }

}
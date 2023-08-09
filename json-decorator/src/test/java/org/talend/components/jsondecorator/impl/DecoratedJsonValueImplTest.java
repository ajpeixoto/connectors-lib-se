package org.talend.components.jsondecorator.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.talend.components.jsondecorator.api.DecoratedJsonValue;
import org.talend.components.jsondecorator.api.JsonDecoratorBuilder;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonPatch;
import javax.json.JsonValue;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DecoratedJsonValueImplTest {

    @Test
    public void ident() {
        JsonValue json = TestUtil.loadJson("/json/geologistsComplex.json");

        JsonDecoratorBuilder builder = JsonDecoratorFactoryImpl.getInstance().createBuilder();
        JsonValue decoratedJsonValue = builder.build(json);

        JsonPatch diff = Json.createDiff(json.asJsonObject(), decoratedJsonValue.asJsonObject());
        Assertions.assertEquals(0, diff.toJsonArray().size());

        JsonNumber content_length_value = decoratedJsonValue.asJsonObject().getJsonNumber("content_length");
        JsonValue.ValueType content_length_type = content_length_value.getValueType();
        Assertions.assertEquals(JsonValue.ValueType.NUMBER, content_length_type);
        Assertions.assertTrue(content_length_value.isIntegral());

        JsonArray contentArray = decoratedJsonValue.asJsonObject().getJsonArray("content");
        contentArray.stream().forEach(e -> {
            JsonObject element = e.asJsonObject();
            Assertions.assertEquals(JsonValue.ValueType.STRING, element.get("tel").getValueType());
        });
    }

    @Test
    public void forceTypes() throws IOException {
        JsonValue json = TestUtil.loadJson("/json/geologistsComplex.json");

        JsonDecoratorBuilder builder = JsonDecoratorFactoryImpl.getInstance().createBuilder();
        JsonValue decoratedJsonValue = builder
                .cast("/content_length", JsonDecoratorBuilder.ValueTypeExtended.FLOAT)
                .cast("/content/age", JsonDecoratorBuilder.ValueTypeExtended.FLOAT)
                .cast("/content/name", JsonDecoratorBuilder.ValueTypeExtended.ARRAY)
                .cast("/content/address/zipcode", JsonDecoratorBuilder.ValueTypeExtended.FLOAT)
                .cast("/content/tel", JsonDecoratorBuilder.ValueTypeExtended.INT)
                .cast("/content/bag", JsonDecoratorBuilder.ValueTypeExtended.STRING)
                .build(json);

        JsonPatch diff = Json.createDiff(json.asJsonObject(), decoratedJsonValue.asJsonObject());
        if (true) {
            // Display the diff
            diff.toJsonArray().stream().forEach(d -> System.out.println(String.format("%s=%s", d.asJsonObject().getString("path"), d.toString())));
        }

        Map<String, JsonValue> diffMap = diff.toJsonArray().stream().collect(Collectors.toMap(j -> j.asJsonObject().getString("path").toString(), j -> j));

        Properties prop = TestUtil.loadProperties("/diff/forceTypes.properties");
        prop.forEach((k, v) -> Assertions.assertEquals(v, diffMap.get(k).toString()));
        Assertions.assertEquals(prop.size(), diff.toJsonArray().size());

        JsonNumber content_length_value = decoratedJsonValue.asJsonObject().getJsonNumber("content_length");
        JsonValue.ValueType content_length_type = content_length_value.getValueType();
        Assertions.assertEquals(JsonValue.ValueType.NUMBER, content_length_type);
        Assertions.assertFalse(content_length_value.isIntegral());

        JsonArray contentArray = decoratedJsonValue.asJsonObject().getJsonArray("content");
        contentArray.stream().forEach(e -> {
            JsonObject element = e.asJsonObject();
            Assertions.assertEquals(JsonValue.ValueType.NUMBER, element.get("tel").getValueType());
        });

    }

    @ParameterizedTest
    @ValueSource(strings = {"STRING", "INT", "BOOLEAN"})
    public void filterByOneType(String filterTypeStr) throws IOException {
        JsonDecoratorBuilder.ValueTypeExtended valueTypeExtended = JsonDecoratorBuilder.ValueTypeExtended.valueOf(filterTypeStr);
        JsonValue json = TestUtil.loadJson("/json/geologistsComplex.json");

        JsonDecoratorBuilder builder = JsonDecoratorFactoryImpl.getInstance().createBuilder();
        JsonValue decoratedJsonValue = builder
                .filterByType("/content/bag", valueTypeExtended)
                .build(json);

        JsonArray content = decoratedJsonValue.asJsonObject().getJsonArray("content");
        for(JsonObject obj : content.getValuesAs(JsonObject.class)) {
            JsonArray bag = obj.getJsonArray("bag");
            bag.stream().forEach(v -> Assertions.assertTrue(valueTypeExtended.accept(v)));
            Assertions.assertEquals(3, bag.size());
        }

    }

}
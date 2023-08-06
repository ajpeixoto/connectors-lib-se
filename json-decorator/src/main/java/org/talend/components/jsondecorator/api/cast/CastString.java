package org.talend.components.jsondecorator.api.cast;

import org.talend.components.jsondecorator.api.Cast;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CastString implements Cast<JsonString> {
    @Override
    public JsonArray toArray(JsonString value) throws JsonDecoratorCastException {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        value.getString().codePoints().forEach(c -> arrayBuilder.add(new String(Character.toChars(c))));
        return arrayBuilder.build();
    }

    @Override
    public JsonObject toObject(JsonString value) throws JsonDecoratorCastException {
        JsonObject object = Json.createObjectBuilder().add(DEFAULT_NAME, value).build();
        return object;
    }

    @Override
    public JsonString toString(JsonString value) throws JsonDecoratorCastException {
        return value;
    }

    @Override
    public JsonNumber toFloat(JsonString value) throws JsonDecoratorCastException {
        String string = value.getString();
        double d = Double.parseDouble(string);
        JsonNumber number = Json.createValue(d);
        return number;
    }

    @Override
    public JsonNumber toInt(JsonString value) throws JsonDecoratorCastException {
        String string = value.getString();
        int i = Integer.parseInt(string);
        JsonNumber number = Json.createValue(i);
        return number;
    }

    @Override
    public JsonValue toBoolean(JsonString value) throws JsonDecoratorCastException {
        String string = value.getString();
        JsonValue bool = Boolean.getBoolean(string) ? JsonValue.FALSE : JsonValue.TRUE;
        return bool;
    }
}

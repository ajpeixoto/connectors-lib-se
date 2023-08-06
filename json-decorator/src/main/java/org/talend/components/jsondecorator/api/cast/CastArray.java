package org.talend.components.jsondecorator.api.cast;

import org.talend.components.jsondecorator.api.Cast;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import java.math.BigInteger;
import java.util.stream.Collectors;

@Deprecated
public class CastArray implements Cast<JsonArray> {
    @Override
    public JsonArray toArray(JsonArray value) throws JsonDecoratorCastException {
        return value;
    }

    @Override
    public JsonObject toObject(JsonArray value) throws JsonDecoratorCastException {
        throw new JsonDecoratorCastException("Can't cast JsonArray to Object.");
    }

    @Override
    public JsonString toString(JsonArray value) throws JsonDecoratorCastException {
        throw new JsonDecoratorCastException("Can't cast JsonArray to String.");
    }

    @Override
    public JsonNumber toFloat(JsonArray value) throws JsonDecoratorCastException {
        throw new JsonDecoratorCastException("Can't cast JsonArray to Float.");
    }

    /**
     * Cast to a number containing the size of given array.
     * @param value
     * @return
     * @throws JsonDecoratorCastException
     */
    @Override
    public JsonNumber toInt(JsonArray value) throws JsonDecoratorCastException {
        JsonNumber number = Json.createValue(value.size());
        return number;
    }

    /**
     * Cast to TRUE if the array is empty, FALSE if not empty.
     * @param value
     * @return
     * @throws JsonDecoratorCastException
     */
    @Override
    public JsonValue toBoolean(JsonArray value) throws JsonDecoratorCastException {
        JsonValue bool = value.isEmpty() ? JsonValue.TRUE : JsonValue.FALSE;
        return bool;
    }
}

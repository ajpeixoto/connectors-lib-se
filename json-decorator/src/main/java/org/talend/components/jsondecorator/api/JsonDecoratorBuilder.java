package org.talend.components.jsondecorator.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.talend.components.jsondecorator.api.cast.JsonDecoratorCastException;

import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface JsonDecoratorBuilder {

    /**
     * Force, and try to cast, values to the desired type.
     * If the path references an object attribute, it will change its type and cast the value.
     * If the path references an array, it will try to force the type and cast all elements of the array.
     *
     * @param path              The path of the attribute.
     * @param type              The type to cast.
     * @return The builder.
     */
    JsonDecoratorBuilder cast(String path, ValueTypeExtended type);

    /**
     * Keep only values of the selected type.
     * On an object, it keeps only attributes of the selected type (after cast).
     * On an array, it keeps only values of the desired type.
     *
     * @param path The path of the object or the array.
     * @param type The type to keep.
     * @return The builder.
     */
    JsonDecoratorBuilder filterByType(String path, ValueTypeExtended type);


    /**
     * Decorate the given jsonValue with the configured decorator.
     *
     * @param json The jsonValue to decorate.
     * @return An implementation of decorated JsonValue
     */
    DecoratedJsonValue build(JsonValue json);

    enum ValueTypeExtended {
        ARRAY,
        OBJECT,
        STRING,
        FLOAT,
        INT,
        BOOLEAN,
    }

    interface JsonDecorator {
        Map<String, CastAttribute> getCastAttributeMap();

        Map<String, FilterByType> getFilterByTypeMap();

        Optional<CastAttribute> getCast(String path);

        Optional<FilterByType> getFilterByType(String path);

        JsonValue cast(String path, JsonValue delegatedValue) throws JsonDecoratorCastException;

    }

    @Data
    @AllArgsConstructor
    class CastAttribute {
        private final String path;
        private final ValueTypeExtended type;
    }

    @Data
    @AllArgsConstructor
    class FilterByType {
        private final String path;
        private final ValueTypeExtended type;
    }
}

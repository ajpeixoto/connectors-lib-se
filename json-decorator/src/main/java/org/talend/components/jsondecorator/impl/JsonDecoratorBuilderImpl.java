package org.talend.components.jsondecorator.impl;

import lombok.Data;
import lombok.NonNull;
import org.talend.components.jsondecorator.api.DecoratedJsonValue;
import org.talend.components.jsondecorator.api.JsonDecoratorBuilder;

import javax.json.JsonValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JsonDecoratorBuilderImpl implements JsonDecoratorBuilder {

    private final Decorator decorator = new Decorator();


    @Override
    public JsonDecoratorBuilder cast(@NonNull String path, @NonNull ValueTypeExtended type) {
        this.decorator.getCastAttributeMap().put(path, new CastAttribute(path, type));
        return this;
    }

    @Override
    public JsonDecoratorBuilder filterByType(@NonNull String path, @NonNull ValueTypeExtended type) {
        this.decorator.getFilterByTypeMap().put(path, new FilterByType(path, type));
        return this;
    }

    @Override
    public DecoratedJsonValue build(JsonValue json) {
        return new DecoratedJsonValueImpl(json, decorator, null, null);
    }

}

package org.talend.components.jsondecorator.impl;

import lombok.NonNull;
import org.talend.components.jsondecorator.api.DecoratedJsonValue;
import org.talend.components.jsondecorator.api.JsonDecoratorBuilder;

import javax.json.JsonValue;

public class JsonDecoratorBuilderImpl implements JsonDecoratorBuilder {

    private final Decorator decorator = new Decorator();

    @Override
    public JsonDecoratorBuilder cast(@NonNull String path, @NonNull ValueTypeExtended type) {
        return this.cast(path, type, null);
    }

    @Override
    public JsonDecoratorBuilder cast(@NonNull String path, @NonNull ValueTypeExtended type, String forceNullValue) {
        this.decorator.getCastAttributeMap().put(path, new CastAttribute(path, type, forceNullValue));
        return this;
    }

    @Override
    public JsonDecoratorBuilder filterByType(@NonNull String path, @NonNull ValueTypeExtended type) {
        FilterByTypes filterByTypes = this.decorator.getFilterByTypeMap().computeIfAbsent(path, k -> new FilterByTypes(k));
        if(!filterByTypes.getTypes().contains(type)){
            filterByTypes.getTypes().add(type);
        }
        return this;
    }

    @Override
    public DecoratedJsonValue build(JsonValue json) {
        return new DecoratedJsonValueImpl(json, decorator, null, null);
    }

}

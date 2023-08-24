package org.talend.components.jsondecorator.impl;

import lombok.NonNull;
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
    public JsonDecoratorBuilder addDecorator(JsonDecorator decorator) {
        decorator.getCastAttributeMap().entrySet().stream().forEach(e -> this.decorator.getCastAttributeMap().put(e.getKey(), e.getValue()));
        decorator.getFilterByTypeMap().entrySet().stream().forEach(e -> this.decorator.getFilterByTypeMap().put(e.getKey(), e.getValue()));
        return this;
    }

    @Override
    public JsonValue build(JsonValue json) {
        return build(null, json);
    }

    public JsonValue build(String rootPath, JsonValue json) {
        if(this.decorator.getCastAttributeMap().isEmpty() && this.decorator.getFilterByTypeMap().isEmpty()){
            return json;
        }
        return new DecoratedJsonValueImpl(json, decorator, rootPath, null);
    }

}

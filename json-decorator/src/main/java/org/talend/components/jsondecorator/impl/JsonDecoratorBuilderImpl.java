package org.talend.components.jsondecorator.impl;

import lombok.NonNull;
import org.talend.components.jsondecorator.api.DecoratedJsonValue;
import org.talend.components.jsondecorator.api.JsonDecoratorBuilder;

import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.List;

public class JsonDecoratorBuilderImpl implements JsonDecoratorBuilder {

    private final Decorator decorator = new Decorator();


    @Override
    public JsonDecoratorBuilder cast(@NonNull String path, @NonNull ValueTypeExtended type) {
        this.decorator.getCastAttributeMap().put(path, new CastAttribute(path, type));
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

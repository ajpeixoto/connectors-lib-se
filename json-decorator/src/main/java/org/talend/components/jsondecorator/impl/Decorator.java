package org.talend.components.jsondecorator.impl;

import lombok.Data;
import org.talend.components.jsondecorator.api.JsonDecoratorBuilder;
import org.talend.components.jsondecorator.api.cast.CastFactory;
import org.talend.components.jsondecorator.api.cast.JsonDecoratorCastException;

import javax.json.JsonValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
class Decorator implements JsonDecoratorBuilder.JsonDecorator {
    private Map<String, JsonDecoratorBuilder.CastAttribute> castAttributeMap = new HashMap();

    private Map<String, JsonDecoratorBuilder.FilterByTypes> filterByTypeMap = new HashMap();

    @Override
    public Optional<JsonDecoratorBuilder.CastAttribute> getCast(String path) {
        return Optional.ofNullable(this.castAttributeMap.get(path));
    }

    @Override
    public Optional<JsonDecoratorBuilder.FilterByTypes> getFilterByType(String path) {
        return Optional.ofNullable(this.filterByTypeMap.get(path));
    }

    @Override
    public JsonValue cast(String path, JsonValue delegatedValue) throws JsonDecoratorCastException {
        Optional<JsonDecoratorBuilder.CastAttribute> optCast = this.getCast(path);

        if(optCast.isEmpty()) {
            return delegatedValue;
        }

        JsonValue cast = CastFactory.getInstance().cast(delegatedValue, optCast.get());

        return cast;
    }
}

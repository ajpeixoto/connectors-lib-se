package org.talend.components.jsondecorator.impl;

import org.talend.components.jsondecorator.api.JsonDecoratorBuilder;
import org.talend.components.jsondecorator.api.cast.JsonDecoratorCastException;

import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class DecoratedJsonObject extends DecoratedJsonValueImpl implements JsonObject {

    private final JsonObject delegateAsJsonObject;

    DecoratedJsonObject(JsonValue delegate, JsonDecoratorBuilder.JsonDecorator decorator, String path, JsonValue parent) {
        super(delegate, decorator, path, parent);
        this.delegateAsJsonObject = JsonObject.class.cast(super.getDelegate());
    }


    @Override
    public JsonArray getJsonArray(String s) {
        return new DecoratedJsonArray(this.delegateAsJsonObject.getJsonArray(s), this.getDecorator(), this.buildPath(s), this);
    }

    @Override
    public DecoratedJsonObject getJsonObject(String s) {
        return new DecoratedJsonObject(this.delegateAsJsonObject.getJsonObject(s), this.getDecorator(), this.buildPath(s), this);
    }

    @Override
    public JsonNumber getJsonNumber(String s) {
        /* String p = this.buildPath(s);
        JsonValue value = this.delegateAsJsonObject.get(s);

        Optional<JsonDecoratorBuilder.CastAttribute> optCast = this.getDecorator().getCast(this.buildPath(s));

        if (optCast.isPresent()) {
            JsonDecoratorBuilder.CastAttribute cast = optCast.get();
            CastFactory.getInstance().
        }

        return JsonNumber.class.cast(value);
        ;*/

        JsonValue jsonValue = this.get(s);
        return  JsonNumber.class.cast(jsonValue);
    }

    @Override
    public JsonString getJsonString(String s) {
        return this.delegateAsJsonObject.getJsonString(s);
    }

    @Override
    public String getString(String s) {
        return this.delegateAsJsonObject.getString(s);
    }

    @Override
    public String getString(String s, String s1) {
        return this.delegateAsJsonObject.getString(s, s1);
    }

    @Override
    public int getInt(String s) {
        return this.delegateAsJsonObject.getInt(s);
    }

    @Override
    public int getInt(String s, int i) {
        return this.getInt(s, i);
    }

    @Override
    public boolean getBoolean(String s) {
        return this.getBoolean(s);
    }

    @Override
    public boolean getBoolean(String s, boolean b) {
        return this.getBoolean(s, b);
    }

    @Override
    public boolean isNull(String s) {
        return this.delegateAsJsonObject.isNull(s);
    }

    @Override
    public int size() {
        return this.delegateAsJsonObject.size();
    }

    @Override
    public boolean isEmpty() {
        return this.delegateAsJsonObject.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.delegateAsJsonObject.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.delegateAsJsonObject.containsValue(value);
    }

    @Override
    public JsonValue get(Object key) {
        try {
            JsonValue delegatedValue = this.delegateAsJsonObject.get(key);
            if(delegatedValue.getValueType() == ValueType.OBJECT){
                delegatedValue = new DecoratedJsonObject(delegatedValue, this.getDecorator(), this.buildPath(String.class.cast(key)), this);
            }
            else if(delegatedValue.getValueType() == ValueType.ARRAY){
                delegatedValue = new DecoratedJsonArray(delegatedValue, this.getDecorator(), this.buildPath(String.class.cast(key)), this);
            }
            JsonValue cast = this.getDecorator().cast(this.buildPath(String.class.cast(key)), delegatedValue);
            return cast;
        }
        catch (JsonDecoratorCastException e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public JsonValue put(String key, JsonValue value) {
        return this.delegateAsJsonObject.put(key, value);
    }

    @Override
    public JsonValue remove(Object key) {
        return this.delegateAsJsonObject.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends JsonValue> m) {
        this.delegateAsJsonObject.putAll(m);
    }

    @Override
    public void clear() {
        this.delegateAsJsonObject.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.delegateAsJsonObject.keySet();
    }

    @Override
    public Collection<JsonValue> values() {
        return this.delegateAsJsonObject.values();
    }

    @Override
    public Set<Entry<String, JsonValue>> entrySet() {
        return this.delegateAsJsonObject.entrySet();
    }

    @Override
    public ValueType getValueType() {
        return this.delegateAsJsonObject.getValueType();
    }

    @Override
    public String toString() {
        return String.format("DecoratedJsonObject(%s)", this.delegateAsJsonObject.toString());
    }
}

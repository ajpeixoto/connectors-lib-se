package org.talend.components.jsondecorator.impl;

import org.talend.components.jsondecorator.api.JsonDecoratorBuilder;
import org.talend.components.jsondecorator.api.cast.JsonDecoratorCastException;

import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class DecoratedJsonArray extends DecoratedJsonValueImpl implements JsonArray {

    private final JsonArray delegateAsJsonArray;

    DecoratedJsonArray(JsonValue delegate, JsonDecoratorBuilder.JsonDecorator decorator, String path, JsonValue parent) {
        super(delegate, decorator, path, parent);
        this.delegateAsJsonArray = JsonArray.class.cast(super.getDelegate());
    }

    @Override
    public JsonObject getJsonObject(int i) {
        return new DecoratedJsonObject(this.delegateAsJsonArray.getJsonObject(i), this.getDecorator(), this.buildPath("x"), this);
    }

    @Override
    public JsonArray getJsonArray(int i) {
        return new DecoratedJsonArray(this.delegateAsJsonArray.getJsonArray(i), this.getDecorator(), this.buildPath("y"), this);
    }

    @Override
    public JsonNumber getJsonNumber(int i) {
        return this.delegateAsJsonArray.getJsonNumber(i);
    }

    @Override
    public JsonString getJsonString(int i) {
        return this.delegateAsJsonArray.getJsonString(i);
    }

    @Override
    public <T extends JsonValue> List<T> getValuesAs(Class<T> aClass) {
        return this.delegateAsJsonArray.getValuesAs(aClass);
    }

    @Override
    public String getString(int i) {
        return this.delegateAsJsonArray.getString(i);
    }

    @Override
    public String getString(int i, String s) {
        return this.delegateAsJsonArray.getString(i, s);
    }

    @Override
    public int getInt(int i) {
        return this.delegateAsJsonArray.getInt(i);
    }

    @Override
    public int getInt(int i, int i1) {
        return this.delegateAsJsonArray.getInt(i, i1);
    }

    @Override
    public boolean getBoolean(int i) {
        return this.delegateAsJsonArray.getBoolean(i);
    }

    @Override
    public boolean getBoolean(int i, boolean b) {
        return this.delegateAsJsonArray.getBoolean(i, b);
    }

    @Override
    public boolean isNull(int i) {
        return this.delegateAsJsonArray.isNull(i);
    }

    @Override
    public int size() {
        return this.delegateAsJsonArray.size();
    }

    @Override
    public boolean isEmpty() {
        return this.delegateAsJsonArray.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.delegateAsJsonArray.contains(o);
    }

    @Override
    public Iterator<JsonValue> iterator() {
        return this.delegateAsJsonArray.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.delegateAsJsonArray.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.delegateAsJsonArray.toArray(a);
    }

    @Override
    public boolean add(JsonValue jsonValue) {
        return this.delegateAsJsonArray.add(jsonValue);
    }

    @Override
    public boolean remove(Object o) {
        return this.delegateAsJsonArray.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.delegateAsJsonArray.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends JsonValue> c) {
        return this.delegateAsJsonArray.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends JsonValue> c) {
        return this.delegateAsJsonArray.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.delegateAsJsonArray.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.delegateAsJsonArray.retainAll(c);
    }

    @Override
    public void clear() {
        this.delegateAsJsonArray.clear();
    }

    @Override
    public JsonValue get(int index) {
        try {
            JsonValue value = this.delegateAsJsonArray.get(index);
            ValueType delegatedValueType = value.getValueType();
            switch (delegatedValueType){
                case OBJECT:
                    value = new DecoratedJsonObject(value, this.getDecorator(), this.getPath(), this);
                    break;
            }
            JsonValue cast = this.getDecorator().cast(this.getPath(), value);
            return cast;
        }
        catch (JsonDecoratorCastException e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public JsonValue set(int index, JsonValue element) {
        return this.delegateAsJsonArray.set(index, element);
    }

    @Override
    public void add(int index, JsonValue element) {
        this.delegateAsJsonArray.add(index, element);
    }

    @Override
    public JsonValue remove(int index) {
        return this.delegateAsJsonArray.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.delegateAsJsonArray.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.delegateAsJsonArray.lastIndexOf(o);
    }

    @Override
    public ListIterator<JsonValue> listIterator() {
        return this.delegateAsJsonArray.listIterator();
    }

    @Override
    public ListIterator<JsonValue> listIterator(int index) {
        return this.delegateAsJsonArray.listIterator(index);
    }

    @Override
    public List<JsonValue> subList(int fromIndex, int toIndex) {
        return this.delegateAsJsonArray.subList(fromIndex, toIndex);
    }
}

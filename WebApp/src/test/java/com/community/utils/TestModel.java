package com.community.utils;

import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by keljd on 12/11/2016.
 */
public class TestModel implements org.springframework.ui.Model {

    private Map<String, Object> attributes = new Hashtable<String, Object>();

    @Override
    public Model addAttribute(String attributeName, Object attributeValue) {
        attributes.put(attributeName, attributeValue);
        return this;
    }

    @Override
    public Model addAttribute(Object attributeValue) {
        return null;
    }

    @Override
    public Model addAllAttributes(Collection<?> attributeValues) {
        return null;
    }

    @Override
    public Model addAllAttributes(Map<String, ?> attributes) {
        return null;
    }

    @Override
    public Model mergeAttributes(Map<String, ?> attributes) {
        return null;
    }

    @Override
    public boolean containsAttribute(String attributeName) {
        return attributes.containsKey(attributeName);
    }

    @Override
    public Map<String, Object> asMap() {
        return attributes;
    }
}



package com.learntony.microservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class JacksonUtils {

    public static <T> T read(String data, Class<T> clazz) {

        if (StringUtils.isEmpty(data)) {
            return null;
        }

        ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        T result = null;
        try {
            result = objectMapper.readValue(data, clazz);
        } catch (JsonProcessingException ex) {
            return null;
        }

        return result;
    }

    public static <T> T readObject(Object data, Class<T> clazz) {

        if (data == null) {
            return null;
        }

        ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T result = null;
        try {
            result = objectMapper.convertValue(data, clazz);
        } catch (Exception ex) {
            return null;
        }

        return result;
    }

    public static <T> List<T> readObjectAsList(Object jsonObject, Class<T> clazz) {

        List<T> result = null;

        ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            result = mapper.convertValue(jsonObject,
                mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
        } catch (Exception ex) {
            return null;
        }

        return result;
    }

    public static <T> String write(T data) {

        if (data == null) {
            return null;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
            return "null";
        }

        return result;
    }
}

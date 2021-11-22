package com.learntony.microservice.productservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
            log.error("json processing exception when read data of " +
                (StringUtils.isEmpty(data) ? "null" : data));
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
            log.error("json processing exception when read data of " + data);
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
            log.error("json processing exception when read data of " + jsonObject);
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
            log.error("json processing exception when read data of " +
                (ObjectUtils.isEmpty(data) ? "null" : data));
        }

        return result;
    }
}

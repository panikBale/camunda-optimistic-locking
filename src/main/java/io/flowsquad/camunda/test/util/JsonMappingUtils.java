package io.flowsquad.camunda.test.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonMappingUtils {

    public static <T> String convertToString (T object, boolean withRootValue) {
        try {
            ObjectMapper mapper = JsonMapper.builder().build();
            if (withRootValue) {
                mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            }
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T convertToObject (String json, Class<T> clazz) {
        ObjectMapper mapper = JsonMapper.builder().build();
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
package com.cotyledon;

import com.cotyledon.vo.DemoVO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class JsonUtil {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyyMMddHHmmss"));
    }

    public static String ToJson(Object object) throws JsonException {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }

    public static <T> T FromJson(String content, Class<T> pattern)
            throws JsonException {
        try {
            return objectMapper.readValue(content, pattern);
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }

    public static <T> T CollectionFromJson(String content, Class collect, Class clazz) throws JsonException {
        try {
            return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(collect, clazz));
        } catch (IOException e) {
            throw new JsonException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> MapfromJson(String JsonString)
            throws JsonException {

        Map<String, Object> map = null;

        try {
            map = objectMapper.readValue(JsonString, Map.class);
        } catch (Exception e) {
            throw new JsonException(e);
        }

        return map;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, String> JsonToMapStr(String JsonString) throws JsonException {
        Map<String, String> map = null;
        try {
            map = objectMapper.readValue(JsonString, Map.class);
        } catch (Exception e) {
            throw new JsonException(e);
        }
        return map;
    }

    public static Map<String, Object> JsonToMap(String JsonString)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> map = null;
        map = objectMapper.readValue(JsonString,
                new TypeReference<Map<String, Object>>() {
                });
        return map;
    }

    public static Map<String,Object> converMap(Object obj){
        return objectMapper.convertValue(obj,Map.class);
    }


    public static class JsonException extends Exception {
        private static final long serialVersionUID = 1L;
        private Exception e;

        public JsonException(Exception e) {
            this.e = e;
        }

        @Override
        public String getMessage() {
            return this.e.getMessage();
        }

        @Override
        public synchronized Throwable getCause() {
            return this.e.getCause();
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return super.getStackTrace();
        }
    }


    public  static  void main(String [] args){
//       List<DemoVO> demoVOList=null;
    }

}
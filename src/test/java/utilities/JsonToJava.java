package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToJava {
    // ObjectMapper'ı volatile olarak tanımla
    private static volatile ObjectMapper mapper = null;

    // Synchronized kullanarak singleton pattern uygula
    private static ObjectMapper getMapper() {
        if (mapper == null) {
            synchronized (JsonToJava.class) {
                if (mapper == null) {
                    mapper = new ObjectMapper();
                }
            }
        }
        return mapper;
    }

    // Genel metodun düzeltilmiş hali
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls) {
        T javaResult = null;
        try {
            // ObjectMapper'ı getMapper metoduyla al
            javaResult = getMapper().readValue(json, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaResult;
    }
}

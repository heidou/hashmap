package mengka.queue.ConcurrentLinkedQueue_02;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtil {

    private static Log logger = LogFactory.getLog(JsonUtil.class);
    private static ObjectMapper mapper = new ObjectMapper().configure(
        DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    /**
     * 根据json字符串生成javabean的方法
     * 
     * @param json
     * @param clazz
     * @return
     * @throws java.io.IOException
     */
    public static Object parseJson(String json, Class<?> clazz) throws IOException {
        // 忽略不认识的属性，不报异常
    	logger.info("忽略不认识的属性，不报异常");
        return mapper.readValue(json, clazz);
    }


    /**
     * 通过TypeReference指定转换类型
     * 
     * @param <T>
     * @param json
     * @param typeReference
     * @return
     * @throws IOException
     */
    public static <T> T parseJson(String json, TypeReference<T> typeReference) {
        try {
            return (T)mapper.readValue(json, typeReference);
        }
        catch (JsonParseException e) {
            logger.error(json, e);
        }
        catch (JsonMappingException e) {
            logger.error(json, e);
        }
        catch (IOException e) {
            logger.error(json, e);
        }
        return null;
    }


    /**
     * 根据java的bean对象生成json字符串
     * 
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        if (object == null) {
            return "";
        }
        try {
            return mapper.writeValueAsString(object);
        }
        catch (Exception e) {
            logger.error(object.toString(), e);
        }
        return "";
    }
}

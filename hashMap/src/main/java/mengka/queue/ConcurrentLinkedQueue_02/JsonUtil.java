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
     * ����json�ַ�������javabean�ķ���
     * 
     * @param json
     * @param clazz
     * @return
     * @throws java.io.IOException
     */
    public static Object parseJson(String json, Class<?> clazz) throws IOException {
        // ���Բ���ʶ�����ԣ������쳣
    	logger.info("���Բ���ʶ�����ԣ������쳣");
        return mapper.readValue(json, clazz);
    }


    /**
     * ͨ��TypeReferenceָ��ת������
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
     * ����java��bean��������json�ַ���
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

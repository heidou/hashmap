package mengka.serializable_01;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * ���л���һ��<br>
 *       Serializable
 * <hr>
 * <ul>
 *   <li>���л���Serialization����һ�ֽ�������һ�������ֽ������Ĺ��̣�<br>
 *      �����л���deserialization����һ�ֽ���Щ�ֽ��ؽ���һ������Ĺ���</li>
 *   <li>serialVersionUID���ԣ� <br>
 *        <ul>
 *          <li>ȷ����汾�ļ�����;</li>
 *          <li>���������ɷ�ʽ��һ����Ĭ�ϵ�1L;һ���Ǹ����������ӿ�������Ա���������Ե�������һ��64λ�Ĺ�ϣ�ֶ�;</li>
 *          <li>��������ʹĳ��������֮��Ӧ�Ķ����Ѿ����л���ȥ�������޸ģ��ö�����Ȼ���Ա���ȷ�����л�;(����Ĭ��jvm���㣬����֮��ǰ���������һ�£��޷�����)</li>
 *        </ul>
 *   </li>
 * </ul>
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		/**
		 *  ��һ��
		 *     ���л�
		 */
		Baicai baicai = new Baicai();
		baicai.setId(1001);
		baicai.setName("da baicai..");
		Map map = new HashMap();
		map.put("aa", "baicai");
		map.put("bb", "qingcai");
		baicai.setAaMap(map);
		String content = JSON.toJSONString(baicai);
		System.out.println(content);
		
		/**
		 *  ������
		 *     �����л�
		 */
		JSONObject jsonObject = (JSONObject) JSON.parse(content);
		System.out.println("id = "+jsonObject.getInteger("id"));
		JSONObject mapObject = jsonObject.getJSONObject("aaMap");
		System.out.println("aa = "+mapObject.getString("aa"));
		System.out.println("bb = "+mapObject.getString("bb"));
	}

}

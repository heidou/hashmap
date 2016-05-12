package mengka.serializable_01;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 序列化法一：<br>
 *       Serializable
 * <hr>
 * <ul>
 *   <li>序列化（Serialization）是一种将对象以一连串的字节描述的过程；<br>
 *      反序列化（deserialization）是一种将这些字节重建成一个对象的过程</li>
 *   <li>serialVersionUID属性： <br>
 *        <ul>
 *          <li>确保类版本的兼容性;</li>
 *          <li>有两种生成方式：一个是默认的1L;一个是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段;</li>
 *          <li>这样，即使某个类在与之对应的对象已经序列化出去后做了修改，该对象依然可以被正确反序列化;(否则，默认jvm计算，升级之后，前后计算结果不一致，无法兼容)</li>
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
		 *  例一：
		 *     序列化
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
		 *  例二：
		 *     反序列化
		 */
		JSONObject jsonObject = (JSONObject) JSON.parse(content);
		System.out.println("id = "+jsonObject.getInteger("id"));
		JSONObject mapObject = jsonObject.getJSONObject("aaMap");
		System.out.println("aa = "+mapObject.getString("aa"));
		System.out.println("bb = "+mapObject.getString("bb"));
	}

}

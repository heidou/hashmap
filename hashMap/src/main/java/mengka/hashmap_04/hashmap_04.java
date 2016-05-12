package mengka.hashmap_04;

import java.util.concurrent.ConcurrentHashMap;

/**
 *  putIfAbsent()��������֤ԭ����
 * 
 * @author mengka.hyy
 *
 */
public class hashmap_04 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		ConcurrentHashMap map = new ConcurrentHashMap();
		
		/**
		 *  key="bb"��map��oldValue�����ڣ�����map��put����
		 */
		Object result1 = map.putIfAbsent("bb", "baicai BBB");
		System.out.println("result1 = "+result1);
		System.out.println("bb = "+map.get("bb"));
		
		/**
		 *   key="aa"���Ѿ���map����ڣ�������map��put����
		 */
		map.put("aa", "baicai AAA");
		Object result2 = map.putIfAbsent("aa", "baicai ccc");		
		System.out.println("result2 = "+result2);		
		System.out.println("aa = "+map.get("aa"));		
	}

}

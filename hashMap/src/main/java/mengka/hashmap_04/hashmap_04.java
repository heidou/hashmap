package mengka.hashmap_04;

import java.util.concurrent.ConcurrentHashMap;

/**
 *  putIfAbsent()方法，保证原子性
 * 
 * @author mengka.hyy
 *
 */
public class hashmap_04 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		ConcurrentHashMap map = new ConcurrentHashMap();
		
		/**
		 *  key="bb"，map里oldValue不存在，则往map里put数据
		 */
		Object result1 = map.putIfAbsent("bb", "baicai BBB");
		System.out.println("result1 = "+result1);
		System.out.println("bb = "+map.get("bb"));
		
		/**
		 *   key="aa"，已经在map里存在，则不再往map里put数据
		 */
		map.put("aa", "baicai AAA");
		Object result2 = map.putIfAbsent("aa", "baicai ccc");		
		System.out.println("result2 = "+result2);		
		System.out.println("aa = "+map.get("aa"));		
	}

}

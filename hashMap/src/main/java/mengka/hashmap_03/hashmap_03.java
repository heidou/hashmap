package mengka.hashmap_03;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  hashmap的线程安全的实现:<br>
 *     Collections.synchronizedMap(new HashMap());	
 * <hr>
 * 由于hashmap是非线程安全的实现，若在并发情景下不保持足够的同步，则会在map.get(key,value)的时候，死循环，<br>
 * 但有着[快速查找]的功能，<br>
 * 实现安全的方法有
 * <ul>
 *   <li>使用Collections.synchronizedMap(new HashMap());或Collections.unmodifiableMap(new HashMap());</li>
 *   <li>使用ConcurrentHashMap;</li>
 *   <li>自行同步;</li>
 * </ul>  
 * 
 * @author mengka.hyy
 *
 */
public class hashmap_03 {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		//线程安全的hashMap
		Map map = Collections.synchronizedMap(new HashMap());
		
		map.put("11","baicai");
		map.put("22","qingcai");
		map.put("33","xigua");
		
		Set set = map.keySet();
		
		synchronized (map) {
			 Iterator iterator = set.iterator(); // Must be in synchronized block      
			 while (iterator.hasNext())          
				 foo(iterator.next());
		}
	}
	
	
	public static void foo(Object obj){
		System.out.println(obj);
	}

}

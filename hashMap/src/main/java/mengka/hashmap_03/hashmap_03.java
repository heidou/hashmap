package mengka.hashmap_03;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  hashmap���̰߳�ȫ��ʵ��:<br>
 *     Collections.synchronizedMap(new HashMap());	
 * <hr>
 * ����hashmap�Ƿ��̰߳�ȫ��ʵ�֣����ڲ����龰�²������㹻��ͬ���������map.get(key,value)��ʱ����ѭ����<br>
 * ������[���ٲ���]�Ĺ��ܣ�<br>
 * ʵ�ְ�ȫ�ķ�����
 * <ul>
 *   <li>ʹ��Collections.synchronizedMap(new HashMap());��Collections.unmodifiableMap(new HashMap());</li>
 *   <li>ʹ��ConcurrentHashMap;</li>
 *   <li>����ͬ��;</li>
 * </ul>  
 * 
 * @author mengka.hyy
 *
 */
public class hashmap_03 {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		//�̰߳�ȫ��hashMap
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

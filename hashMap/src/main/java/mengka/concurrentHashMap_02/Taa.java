package mengka.concurrentHashMap_02;

import java.util.HashMap;

/**
 *  使用线程不安全的HashMap
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public synchronized void add(String key){
		Integer value = map.get(key);
		if(value == null){
			map.put(key, 1);
		}else{
			map.put(key, value+1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

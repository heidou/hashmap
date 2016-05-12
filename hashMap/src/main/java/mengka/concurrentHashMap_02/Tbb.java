package mengka.concurrentHashMap_02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 用ConcurrentHashMap替换Taa里面的HashMap，并且仅仅是去掉synchronized，问题就出来了？？
 *  
 * 
 * @author mengka.hyy
 *
 */
public class Tbb {

	private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
	
	public void add(String key){
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

package mengka.concurrentHashMap_02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ��ConcurrentHashMap�滻Taa�����HashMap�����ҽ�����ȥ��synchronized������ͳ����ˣ���
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

package mengka.LinkedHashMap_01;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class linkedHashMap_01 {

	private final static float DEFAULT_LOAD_FACTOR = 0.75f;
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		int capacity = 5;
		
		LinkedHashMap<String,String> map =new LinkedHashMap<String,String>(capacity, DEFAULT_LOAD_FACTOR, true);
		map.put("a11", "mengka AAA_1..");
		map.put("a22", "mengka AAA_2..");
		map.put("a33", "mengka AAA_3..");
		map.put("a44", "mengka AAA_4..");
		map.put("a55", "mengka AAA_5..");
		map.put("a66", "mengka AAA_6..");
		map.put("a77", "mengka AAA_7..");
			
		Iterator iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry entry = (Entry) iterator.next();
			System.out.println(entry.getKey()+" , "+entry.getValue());
		}
	}

}

package mengka.hashmap_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap_01 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		HashMap aaMap=new HashMap();
		aaMap.put("aa", "[´ó°×²Ë]");
		aaMap.put("bb", "[Çà²Ë]");

		Iterator aaiterator=aaMap.entrySet().iterator();
		while(aaiterator.hasNext()){
			Map.Entry entry=(Map.Entry)aaiterator.next();
			aaMap.put(entry.getKey(), entry.getValue().toString().substring(1, entry.getValue().toString().length()-1));
		}
		
		Iterator bbiterator=aaMap.entrySet().iterator();
		while(bbiterator.hasNext()){
			Map.Entry entry=(Map.Entry)bbiterator.next();
			System.out.println(entry.getKey()+" , "+entry.getValue());
		}
		
		System.out.println(aaMap.size());
	}

}

package mengka.hashmap_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class hashmap_02 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		
		HashMap aaMap =new HashMap();
		aaMap.put("aa", "�ײ�");
		aaMap.put("bb", "���");
		
		HashMap bbMap = new HashMap();
		bbMap.put("aa", "����");
		
		bbMap.putAll(aaMap);
		
		
		Iterator aaiterator=bbMap.entrySet().iterator();
		while(aaiterator.hasNext()){
			Map.Entry entry=(Map.Entry)aaiterator.next();
			System.out.println(entry.getKey()+" , "+entry.getValue());
		}
			
	}

}

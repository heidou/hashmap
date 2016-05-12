package mengka.hashmap_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMap_03 {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();  
		map.put("d", 2);  
		map.put("c", 1);  
		map.put("b", 1);  
		map.put("a", 3);
		
		List<Map.Entry<String, Integer>> infoIds =  
			    new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); 

		
		//≈≈–Ú  
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {     
		    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {        
		        return (o2.getValue() - o1.getValue());   
//		        return (o1.getKey()).toString().compareTo(o2.getKey());  
		    }  
		});
		
		
		Iterator aaiterator=infoIds.iterator();
		while(aaiterator.hasNext()){
			Map.Entry entry=(Map.Entry)aaiterator.next();
			System.out.println(entry.getKey()+" , "+entry.getValue());
		}
		
		
		//≈≈–Ú∫Û  
		for (int i = 0; i < infoIds.size(); i++) {  
		    String id = infoIds.get(i).toString();  
		    System.out.println(id);  
		}  
	}

}

package mengka.treeMap_01;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap会根据key对put进去的数据进行排序：
 *   <hr>
 * baicai , 2<br>
 * hdu , 1<br>
 * qingcai , 3<br>
 * xigua , 4<br>
 * 
 * @author mengka.hyy
 *
 */
public class TreeMap_01 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		
	   Map map = new TreeMap();
	   map.put("hdu", 1);
	   map.put("baicai", 2);
	   map.put("qingcai", 3);
	   map.put("xigua", 4);
	   
	   /**
	    * 法①
	    */
	   Iterator iterator=map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry entry=(Map.Entry)iterator.next();
			System.out.println("<"+entry.getKey()+" , "+entry.getValue()+">");
		}
		
		
		System.out.println("====================");
		
		/**
		 * 法②
		 */
		Set<String> set = map.keySet();
		for(String key:set){
			System.out.println("<"+key+" , "+map.get(key)+">");
		}
	}

}

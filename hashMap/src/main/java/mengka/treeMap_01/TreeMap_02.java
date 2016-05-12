package mengka.treeMap_01;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *  网易网站部面试题，虽然惨败，但是收获良多（chenwei）
 * 
 * @author mengka.hyy
 *
 */
public class TreeMap_02 {

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
		String aaString = "orange.peach.tomato.banana";
		String bbString = aaString.replace(".", "p");
		System.out.println(bbString);
		String[] aaStrings = bbString.split("p");
		
		
		/**
		 * TreeMap会默认进行排序：
		 *    {=2, banana=5, each=3, orange=1, tomato=4}
		 * 
		 */
		Map map = new TreeMap();
		int i=0;
		for(String tmp:aaStrings){
			i++;
			map.put(tmp, i);
		}
		
		Set<String> set = map.keySet();
		for(String key:set){
			if(key.equals("orange")){
				/**
				 * {.., orange=1, tomato=4}，orange被移除，获取后面的数据的时候出错了
				 * 
				 * Exception in thread "main" java.util.ConcurrentModificationException
				 *	at java.util.TreeMap$PrivateEntryIterator.nextEntry(Unknown Source)
				 *	at java.util.TreeMap$KeyIterator.next(Unknown Source)
				 *	at mengka.bj163_01.Taa.main(Taa.java:25)
				 */
				map.remove(key);
			}
			System.out.println(key+"##"+map.get(key));
		}
		
	}
}

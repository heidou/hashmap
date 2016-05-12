package mengka.array_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class array_02 {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		HashMap aaMap=new HashMap();

		//交易中，常用的array使用方法
		aaMap.put("1", new long[]{1,2});
		aaMap.put("2", new int[]{1,2});
		aaMap.put("3", new String[]{"aa","bb"});
		
		
		Iterator aaiterator=aaMap.entrySet().iterator();
		while(aaiterator.hasNext()){
			Map.Entry entry=(Map.Entry)aaiterator.next();
			System.out.println(entry.getKey()+" , "+entry.getValue());
		}
	}

}

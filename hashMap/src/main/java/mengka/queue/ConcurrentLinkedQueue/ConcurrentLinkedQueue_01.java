package mengka.queue.ConcurrentLinkedQueue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueue_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
		
		queue.add("蒙卡aaa");
		queue.add("蒙卡bbb");
		queue.add("蒙卡ccc");
		queue.add("蒙卡ddd");
		queue.add("蒙卡eee");
		
		System.out.println(queue.size());
		
		
		/**
		 *  ConcurrentLinkedQueue到array
		 */
		String[] aaStrings = {};
		aaStrings = queue.toArray(aaStrings);
		
		for(String tmp:aaStrings){
			System.out.println(tmp);
		}
		
		
		/**
		 *  array到list
		 */
		List<String> aaList = Arrays.asList(aaStrings);
		for(String tmp:aaList){
			System.out.println(tmp);
		}
		
		/**
		 *  取出queue里面的所有元素
		 *  
		 */
		String top;
		while((top=queue.poll())!=null){
			System.out.println("top = "+top);
		}
	}

}

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
		
		queue.add("�ɿ�aaa");
		queue.add("�ɿ�bbb");
		queue.add("�ɿ�ccc");
		queue.add("�ɿ�ddd");
		queue.add("�ɿ�eee");
		
		System.out.println(queue.size());
		
		
		/**
		 *  ConcurrentLinkedQueue��array
		 */
		String[] aaStrings = {};
		aaStrings = queue.toArray(aaStrings);
		
		for(String tmp:aaStrings){
			System.out.println(tmp);
		}
		
		
		/**
		 *  array��list
		 */
		List<String> aaList = Arrays.asList(aaStrings);
		for(String tmp:aaList){
			System.out.println(tmp);
		}
		
		/**
		 *  ȡ��queue���������Ԫ��
		 *  
		 */
		String top;
		while((top=queue.poll())!=null){
			System.out.println("top = "+top);
		}
	}

}

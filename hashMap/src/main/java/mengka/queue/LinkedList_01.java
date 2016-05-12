package mengka.queue;

import java.util.LinkedList;
import java.util.Queue;


/**
 *  ��LinkedListʵ�֣��Ƚ��ȳ��Ķ���
 * 
 * @author mengka.hyy
 *
 */
public class LinkedList_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		    Queue<String> queue = new LinkedList<String>();  
	        queue.offer("Hello");  
	        queue.offer("World!");  
	        queue.offer("��ã�");  
	        System.out.println("size = "+queue.size());  
	       
	        
	        String str;  
	        while((str=queue.poll())!=null){  
	            System.out.println(str);  
	        }
	        
	        
	        System.out.println("--------------------");  
	        System.out.println(queue.size()); 

	}

}

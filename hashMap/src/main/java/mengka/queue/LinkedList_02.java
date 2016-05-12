package mengka.queue;

import java.util.NoSuchElementException;
import java.util.LinkedList;


/**
 *  后进先出，利用linkList实现的栈
 * 
 * @author mengka.hyy
 *
 */
public class LinkedList_02 {
	public static void main(String[] args) {

		// LinkedList的栈和队列的使用
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 6; i++) {
			linkedList.push(i);
		}
		System.out.println(linkedList);
		
		try{
			Integer tmpInteger = null;
			while ((tmpInteger=linkedList.pop())!= null) {
				System.out.println(linkedList);
			}
		}catch (Exception e) {
			if(e instanceof NoSuchElementException){
				System.out.println("后进先出，利用linkList实现的栈");
			}
		}
	}
}

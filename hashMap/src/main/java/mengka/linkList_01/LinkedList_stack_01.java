package mengka.linkList_01;

import java.util.NoSuchElementException;
import java.util.LinkedList;


/**
 *  后进先出，利用linkList实现的栈
 *  <hr>
 *  linkList向list中插入和删除开销不大，但随机访问则较慢；<br>
 *  linklist可以当作队列、堆栈、双向链表使用；<br>
 * 
 * @author mengka.hyy
 *
 */
public class LinkedList_stack_01 {
	public static void main(String[] args) {

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

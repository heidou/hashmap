package mengka.linkList_01;

import java.util.NoSuchElementException;
import java.util.LinkedList;


/**
 *  ����ȳ�������linkListʵ�ֵ�ջ
 *  <hr>
 *  linkList��list�в����ɾ���������󣬵���������������<br>
 *  linklist���Ե������С���ջ��˫������ʹ�ã�<br>
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
				System.out.println("����ȳ�������linkListʵ�ֵ�ջ");
			}
		}
	}
}

package mengka.queue;

import java.util.NoSuchElementException;
import java.util.LinkedList;


/**
 *  ����ȳ�������linkListʵ�ֵ�ջ
 * 
 * @author mengka.hyy
 *
 */
public class LinkedList_02 {
	public static void main(String[] args) {

		// LinkedList��ջ�Ͷ��е�ʹ��
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

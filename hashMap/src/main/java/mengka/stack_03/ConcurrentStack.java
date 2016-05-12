package mengka.stack_03;

import java.util.concurrent.atomic.AtomicReference;

/**
 *   ����AtomicReferenceʵ�ֵķ�����ջ
 *   <ul>
 *     <li>�������㷨��ʹ���˵Ͳ㼶�Ĳ���ԭ��(���磺�Ƚϲ�����)��ȡ��������</li>
 *     <li>ԭ�ӱ������û��ṩ�ģ���Щ�Ͳ㼶����ԭ�Ҳ�ܹ����������ѵ�volatile������ʹ�ã�</li>
 *   </ul>
 * <hr>
 * �������㷨��
 * <ul>
 *   <li>һЩ�������ɾ��в�ȷ���ԣ������ܱ���������</li>
 *   <li>�����������㷨��ǰ���ǣ�ά�����ݵ�һ���ԣ�</li>
 *   <li>����AtomicReference����ÿһ�����뱻ԭ�Ӹ��µ����ӣ�</li>
 *   <li>��ʹ�þ�����д��volatile������ͬ���ڴ�ЧӦ��compareAndSet��</li>
 * </ul>
 * 
 * @author mengka.hyy
 *
 * @param <E>
 */
public class ConcurrentStack<E> {
	
	AtomicReference<Node<E>> top = new AtomicReference<ConcurrentStack.Node<E>>();
	
	/**
	 *  ��ջ��pushԪ��<br>
	 *       ���ݵ�ǰջ��״̬���½ڵ㣬�������ԣ�
	 *       ��ʹ�þ�����д��volatile������ͬ���ڴ�ЧӦ��compareAndSet��
	 * 
	 * @param item
	 */
	public void push(E item){
		Node<E> newHead = new Node<E>(item);
		Node<E> oldHead;
		do{
			oldHead = top.get();
			newHead.next = oldHead;
		}while(!top.compareAndSet(oldHead, newHead));
	}

	/**
	 *  ��ջ��popȡ��Ԫ��
	 * 
	 * @return
	 */
	public E pop(){
		Node<E> oldHead;
		Node<E> newHead;
		do{
			oldHead = top.get();
			if(oldHead==null){
				return null;
			}
			newHead = oldHead.next;
		}while(!top.compareAndSet(oldHead, newHead));
		return oldHead.item;
	}
	
	private static class Node<E>{
		public final E item;
		public Node<E> next;
		
		public Node(E item){
			this.item = item;
		}
	}
}

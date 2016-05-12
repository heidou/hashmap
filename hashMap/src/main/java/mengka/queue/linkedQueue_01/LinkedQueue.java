package mengka.queue.linkedQueue_01;

import java.util.concurrent.atomic.AtomicReference;

/**
 *  利用CAS实现的非阻塞队列
 * 
 * @author mengka.hyy
 *
 * @param <E>
 */
public class LinkedQueue<E> {

	private final Node<E> dummy = new Node<E>(null, null);
	
	private final AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(dummy);
	
	private final AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(dummy);
	
	/**
	 *  在队列的tail插入新元素
	 * 
	 * @param item
	 * @return
	 */
	public boolean put(E item){
		Node<E> newNode = new Node<E>(item, null);
		while(true){
			Node<E> currentTail = tail.get();
			Node<E> tailNext = currentTail.next.get();
			
			if(currentTail==tail.get()){
				if(tailNext!=null){
					tail.compareAndSet(currentTail, tailNext);
				}else{
					if(currentTail.next.compareAndSet(null, newNode));
					tail.compareAndSet(currentTail, newNode);
					return true;
				}
			}
		}
	    
	}
	
	private static class Node<E>{
		final E item;
		
		final AtomicReference<Node<E>> next;
		
		public Node(E item,Node<E> next){
			this.item = item;
			this.next = new AtomicReference<Node<E>>(next);
		}
	}
}

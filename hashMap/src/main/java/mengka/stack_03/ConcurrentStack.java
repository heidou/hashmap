package mengka.stack_03;

import java.util.concurrent.atomic.AtomicReference;

/**
 *   利用AtomicReference实现的非阻塞栈
 *   <ul>
 *     <li>非阻塞算法，使用了低层级的并发原语(比如：比较并交换)，取代了锁；</li>
 *     <li>原子变量向用户提供的，这些低层级并发原语，也能够当做“更佳的volatile变量”使用；</li>
 *   </ul>
 * <hr>
 * 非阻塞算法：
 * <ul>
 *   <li>一些任务的完成具有不确定性，并可能必须重做；</li>
 *   <li>创建非阻塞算法的前提是，维护数据的一致性；</li>
 *   <li>利用AtomicReference来表达，每一个必须被原子更新的链接；</li>
 *   <li>它使用具有与写入volatile变量相同的内存效应的compareAndSet；</li>
 * </ul>
 * 
 * @author mengka.hyy
 *
 * @param <E>
 */
public class ConcurrentStack<E> {
	
	AtomicReference<Node<E>> top = new AtomicReference<ConcurrentStack.Node<E>>();
	
	/**
	 *  往栈顶push元素<br>
	 *       根据当前栈的状态更新节点，反复尝试；
	 *       它使用具有与写入volatile变量相同的内存效应的compareAndSet；
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
	 *  从栈顶pop取出元素
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

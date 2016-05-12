package mengka.queue.linkedBlockingQueue;


/**
 *  <font color="red">【线程安全，常被用于做线程池的任务缓冲队列】</font><br>
 *  线程池的支持的任务数的执行 = corePoolSize + BlockingQueue大小<br>
 *  当n>corePoolSize时，会加入到缓冲队列之中
 *  <hr>
 *  链表方式存储对象，进入队列和出去队列都各自有一把锁
 * 
 * @author mengka.hyy
 *
 */
public class linkedBlockingQueue_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

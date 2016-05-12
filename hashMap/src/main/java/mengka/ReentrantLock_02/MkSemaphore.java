package mengka.ReentrantLock_02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *  利用ReentrantLock实现的信号量MkSemaphore
 *  <hr>
 *  阀门控制：
 *  <ul>
 *    <li>ReentrantLock</li>
 *    <li>Semaphore</li>
 *    <li>barrier</li>
 *    <li>CountDownLatch</li>
 * </ul>   
 * 
 * @author mengka.hyy
 *
 */
public class MkSemaphore {

	private final static Log log = LogFactory.getLog(MkSemaphore.class);
	
	private final Lock lock = new ReentrantLock();
	
	private final Condition condition = lock.newCondition();
	
	private int count;
	
	public MkSemaphore(int count) {
		lock.lock();
		try{
			this.count = count;
		}finally{
			lock.unlock();
		}
	}
	
	/**
	 *  获取许可
	 * 
	 * @throws InterruptedException
	 */
	public void acquire() throws InterruptedException {
		lock.lock();
		try{
			while(count<=0){
				/**
				 * Causes the current thread to wait until it is signalled or interrupted.
				 */
				log.info("---------------, ["+Thread.currentThread().getName()+"] semaphore count = 0!!!");
				condition.await();
			}
			--count;
			log.info("----------, ["+Thread.currentThread().getName()+"] semaphore acquire , count = "+count);
		}finally{
			lock.unlock();
		}
	}
	
	/**
	 *  释放
	 * 
	 */
	public void release() {
		lock.lock();
		try{
			++count;
			/**
			 *  Wakes up one waiting thread.
			 */
			condition.signal();
		}finally{
			lock.unlock();
		}
	}
}

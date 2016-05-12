package mengka.CountDownLatch_01;

import java.util.concurrent.CountDownLatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  countDownLatch：<br>
 *  1.开关，控制所有的线程在同一时间开始；<br>
 *  2.开关，控制所有的线程在同一时间结束；<br>
 * <hr>
 * 阀门控制：
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
public class countDownLatch_01 {

	private static final Log log = LogFactory.getLog(countDownLatch_01.class);
	
	public static void main(String[] args) throws Exception{		
		long time = timeTasks(100,new TaaTask());
		log.info("---------- , time = "+time+"ms");
	}
	
	/**
	 *  返回线程的消耗时间
	 * 
	 * @param count 线程个数
	 * @param task 线程
	 * @return
	 * @throws InterruptedException
	 */
	public static long timeTasks(int count,final Runnable task)throws InterruptedException{
		final CountDownLatch startLatch = new CountDownLatch(1);
		final CountDownLatch endLatch = new CountDownLatch(count);
		
		for(int i=0;i<count;i++){
			Thread thread = new Thread(){
				public void run(){
					try{
						startLatch.await();
						try{
							task.run();
						}finally{
							endLatch.countDown();
						}
					}catch(Exception e){
						log.error("timeTasks thread error!",e);
					}
				}
			};
			thread.start();
		}
		
		long start = System.currentTimeMillis();
		
		/**
		 *  开关1：控制所有线程在同一个时间开始
		 */
		startLatch.countDown();
		
		/**
		 *  开关2：控制所有的线程在同一个时间结束
		 */
		endLatch.await();
		
		long end = System.currentTimeMillis();		
		return end - start;
	}

}

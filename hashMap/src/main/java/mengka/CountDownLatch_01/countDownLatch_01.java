package mengka.CountDownLatch_01;

import java.util.concurrent.CountDownLatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  countDownLatch��<br>
 *  1.���أ��������е��߳���ͬһʱ�俪ʼ��<br>
 *  2.���أ��������е��߳���ͬһʱ�������<br>
 * <hr>
 * ���ſ��ƣ�
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
	 *  �����̵߳�����ʱ��
	 * 
	 * @param count �̸߳���
	 * @param task �߳�
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
		 *  ����1�����������߳���ͬһ��ʱ�俪ʼ
		 */
		startLatch.countDown();
		
		/**
		 *  ����2���������е��߳���ͬһ��ʱ�����
		 */
		endLatch.await();
		
		long end = System.currentTimeMillis();		
		return end - start;
	}

}

package mengka.barrier_01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  关卡barrier的使用，确保线程都在同一个时间开始
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	private static CyclicBarrier barrier = new CyclicBarrier(100);
	
	private static AtomicInteger mengka = new AtomicInteger(0);
	
	public static CountDownLatch latch = new CountDownLatch(100);
	
	public static void main(String[] args)throws Exception {
		
		for(int i=0;i<100;i++){
			new Thread(new TaaTask(barrier, mengka,latch)).start();
		}
		
		/**
		 *  所有线程都执行完之后，执行后面的代码
		 */
		latch.await();
		System.out.println("mengka = "+mengka.get());
	}

}

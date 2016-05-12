package mengka.barrier_01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  �ؿ�barrier��ʹ�ã�ȷ���̶߳���ͬһ��ʱ�俪ʼ
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
		 *  �����̶߳�ִ����֮��ִ�к���Ĵ���
		 */
		latch.await();
		System.out.println("mengka = "+mengka.get());
	}

}

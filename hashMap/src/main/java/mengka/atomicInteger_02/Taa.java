package mengka.atomicInteger_02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  4���̣߳���ͬһ��������2����1��2����һ
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	public static CountDownLatch latch = null;
	
	public static AtomicInteger baicai = new AtomicInteger(10);
	
	public static void main(String[] args) throws InterruptedException {
		
		//��֤4���߳�ͬʱִ��
		latch = new CountDownLatch(4);

		for(int i=0;i<2;i++){
			new Thread(new AddTask("addTask["+i+"]")).start();
		}
		
		for(int i=0;i<2;i++){
			new Thread(new DelTask("delTask["+i+"]")).start();
		}
		
		/**
		 *   ��֤���е��̶߳�ִ����ɺ󣬲ź�ִ�к���Ĵ���
		 */
		latch.await();
		
		System.out.print("baicai = "+baicai);
	}

	public static int add(){
		return baicai.incrementAndGet();
	}
	
	public static int delete(){
		return baicai.decrementAndGet();
	}
	
	public static int getBaicai(){
		return baicai.get();
	}
	
}

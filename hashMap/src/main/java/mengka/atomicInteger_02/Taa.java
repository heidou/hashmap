package mengka.atomicInteger_02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  4个线程，对同一个变量，2个加1，2个减一
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	public static CountDownLatch latch = null;
	
	public static AtomicInteger baicai = new AtomicInteger(10);
	
	public static void main(String[] args) throws InterruptedException {
		
		//保证4个线程同时执行
		latch = new CountDownLatch(4);

		for(int i=0;i<2;i++){
			new Thread(new AddTask("addTask["+i+"]")).start();
		}
		
		for(int i=0;i<2;i++){
			new Thread(new DelTask("delTask["+i+"]")).start();
		}
		
		/**
		 *   保证所有的线程都执行完成后，才后执行后面的代码
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

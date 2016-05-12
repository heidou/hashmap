package mengka.concurrentHashMap_03;

import java.util.concurrent.CountDownLatch;

/**
 * 用Collections.synchronizedMap(new HashMap())初始化的threadlocal原理
 * <hr>
 * thread[Thread-1] , mengka[1]<br>
 * thread[Thread-2] , mengka[1]<br>
 * thread[Thread-3] , mengka[1]<br>
 * thread[Thread-2] , mengka[2]<br>
 * thread[Thread-1] , mengka[2]<br>
 * thread[Thread-2] , mengka[3]<br>
 * thread[Thread-3] , mengka[2]<br>
 * thread[Thread-1] , mengka[3]<br>
 * thread[Thread-3] , mengka[3]<br>
 * mengka = 0
 * 
 * 
 * @author mengka.hyy
 * 
 */
public class Taa {

	public static CountDownLatch latch = null;

	public static MengkaThreadLocal<Integer> mengka = new MengkaThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	public static void main(String[] args) throws Exception {
		latch = new CountDownLatch(3);

		Taa taa = new Taa();

		Thread aaThread = new Thread(new TaaTask(taa));
		Thread bbThread = new Thread(new TaaTask(taa));
		Thread ccThread = new Thread(new TaaTask(taa));
		aaThread.start();
		bbThread.start();
		ccThread.start();

		latch.await();
		System.out.println("mengka = " + mengka.get());
	}

	public int getNextNum() {
		mengka.set(mengka.get() + 1);
		return mengka.get();
	}

	public int get() {
		return mengka.get();
	}
}

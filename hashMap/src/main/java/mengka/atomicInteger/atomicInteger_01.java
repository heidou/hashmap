package mengka.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class atomicInteger_01 {

	public final static Mengka mengka = new Mengka();

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		/**
		 * 并发一：
		 * 
		 * 修改AtomicInteger变量
		 */
		new Thread(new Runnable() {

			@Override
			public void run() {

				mengka.setMkCount(new AtomicInteger(100));

				System.out.println("t1: " + mengka.getMkCount());
			}

		}).start();

		/**
		 * 并发二：
		 * 
		 * 修改AtomicInteger变量
		 */
		A a = new A();
		Thread t2 = new Thread(a);
		t2.start();

		// 100ms
		Thread.sleep(100);

		System.out.println(mengka.getMkCount());
	}

}

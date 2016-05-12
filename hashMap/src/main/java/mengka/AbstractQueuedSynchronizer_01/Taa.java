package mengka.AbstractQueuedSynchronizer_01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类似CountDownLatch的一个只有一个总数限制的自定义Latch；
 * <hr>
 * 》》设置的一个闸门：<br>
 * 只有当已经执行的线程超过50个，或者可以说是大盘总数超过了50个后，就可以放一只狼进入羊群了； <br>
 * <br>
 * count = 76<br>
 * count = 64<br>
 * -----------, baicai = 83<br>
 * count = 62<br>
 * count = 63<br>
 * count = 61<br>
 * count = 87<br>
 * count = 88<br>
 * 
 * @author mengka.hyy
 * 
 */
public class Taa {

	public static BooleanLatch latch = null;

	public static AtomicInteger baicai = new AtomicInteger(0);

	public static void main(String[] args) throws Exception {

		latch = new BooleanLatch();

		for (int i = 0; i < 108; i++) {
			new Thread(new TaaTask()).start();
		}

		/**
		 * 设置的一个闸门：<br>
		 * 只有当已经执行的线程超过50个，或者可以说是大盘总数超过了50个后，就可以放一只狼进入羊群了；
		 */
		latch.await();

		System.out.println("-----------, baicai = " + baicai);
	}

	public static int add() {
		return baicai.incrementAndGet();
	}

	public static int decrement() {
		return baicai.decrementAndGet();
	}

	public static int get() {
		return baicai.get();
	}

}

package mengka.AbstractQueuedSynchronizer_01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ����CountDownLatch��һ��ֻ��һ���������Ƶ��Զ���Latch��
 * <hr>
 * �������õ�һ��բ�ţ�<br>
 * ֻ�е��Ѿ�ִ�е��̳߳���50�������߿���˵�Ǵ�������������50���󣬾Ϳ��Է�һֻ�ǽ�����Ⱥ�ˣ� <br>
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
		 * ���õ�һ��բ�ţ�<br>
		 * ֻ�е��Ѿ�ִ�е��̳߳���50�������߿���˵�Ǵ�������������50���󣬾Ϳ��Է�һֻ�ǽ�����Ⱥ�ˣ�
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

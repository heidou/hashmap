package mengka.barrier_01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TaaTask implements Runnable {

	private static final Log log = LogFactory.getLog(TaaTask.class);

	private CyclicBarrier barrier;

	private AtomicInteger mengka;
	
	private CountDownLatch latch;
	
	public TaaTask(CyclicBarrier barrier,AtomicInteger mengka,CountDownLatch latch) {
		this.barrier = barrier;
		this.mengka = mengka;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			/**
			 * 确保所有的线程同时开始
			 */
			barrier.await();
			
			int result = mengka.incrementAndGet();
			log.info("----------, mengka add = "+result);
			
			latch.countDown();
		} catch (Exception e) {
			log.error("TaaTask error!", e);
		}
	}

}

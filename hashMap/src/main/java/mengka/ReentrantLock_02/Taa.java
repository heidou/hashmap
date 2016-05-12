package mengka.ReentrantLock_02;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mengka.common.TimeUtil;

/**
 *  利用MkSemaphore信号量实现的semaphore_01例子
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	private static final Log log = LogFactory.getLog(Taa.class);

	public static final ExecutorService EXECUTOR_SERVICE = Executors
			.newCachedThreadPool();

	public static final MkSemaphore SEMAPHORE = new MkSemaphore(5);

	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			EXECUTOR_SERVICE.execute(new Task(SEMAPHORE));
		}

		EXECUTOR_SERVICE.shutdown();

	}

	/**
	 * 线程池中的一个任务
	 * 
	 * @author mengka.hyy
	 * 
	 */
	public static class Task implements Runnable {

		private MkSemaphore semaphore;

		public Task(MkSemaphore semaphore) {
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				/**
				 * step01: 获得许可
				 */
				semaphore.acquire();

				/**
				 * step02: 执行任务
				 */
				String message = TimeUtil.toDate(new Date(), TimeUtil.format_1);
				log.info("-----------------,["
						+ Thread.currentThread().getName() + "] message = "
						+ message);

				Thread.sleep((long) (Math.random() * 10000));

				/**
				 * step03: 释放
				 */
				semaphore.release();
			} catch (Exception e) {
				log.error("semaphore_01 task error! ", e);
			}
		}

	}

}

package mengka.AbstractQueuedSynchronizer_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TaaTask implements Runnable {

	private static final Log log = LogFactory.getLog(TaaTask.class);

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			int count = Taa.add();
			System.out.println("count = " + count);
			if (count > 50) {
				// »½ÐÑ
				Taa.latch.signal();
			}
		} catch (Exception e) {
			log.error("TaaTask error!", e);
		}
	}
}

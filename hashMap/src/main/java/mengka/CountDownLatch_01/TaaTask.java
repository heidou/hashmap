package mengka.CountDownLatch_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TaaTask implements Runnable{

	private static final Log log = LogFactory.getLog(TaaTask.class);
	
	@Override
	public void run() {
		String content = Thread.currentThread().getName()+" start...";
		log.info("content = "+content);
	}

}

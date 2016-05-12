package mengka.ReentrantReadWriteLock_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  ∂¡œﬂ≥Ã
 * 
 * @author mengka.hyy
 *
 */
public class ReadTask implements Runnable {

	private static final Log log = LogFactory.getLog(ReadTask.class);
	
	ReadWriteMap<String, String> map;

	public ReadTask(ReadWriteMap<String, String> map) {
		this.map = map;
	}

	@Override
	public void run() {
		try {
			String data = map.get("aa");
			log.info("------------------, data = "+data);			
		} catch (Exception e) {
			log.error("ReadTask error!",e);
		}
	}

}

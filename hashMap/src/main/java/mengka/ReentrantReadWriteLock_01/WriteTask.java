package mengka.ReentrantReadWriteLock_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  Ð´Ïß³Ì
 * 
 * @author mengka.hyy
 *
 */
public class WriteTask implements Runnable {

	private static final Log log = LogFactory.getLog(WriteTask.class);
	
	ReadWriteMap<String, String> map;

	public WriteTask(ReadWriteMap<String, String> map) {
		this.map = map;
	}

	@Override
	public void run() {
		try {		
			map.put("aa", "mengka AAA..");
		} catch (Exception e) {
			log.error("ReadTask error!",e);
		}
	}

}

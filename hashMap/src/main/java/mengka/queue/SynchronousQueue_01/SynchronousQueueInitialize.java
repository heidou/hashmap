package mengka.queue.SynchronousQueue_01;

import java.util.concurrent.SynchronousQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  SynchronousQueue∂”¡–
 * 
 * @author mengka.hyy
 *
 */
public class SynchronousQueueInitialize {

    private static final Log log = LogFactory.getLog(SynchronousQueueInitialize.class);

	private static SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
	
	public boolean add(String content){
		try {
			synchronousQueue.put(content);
		} catch (Exception e) {
			log.error("synchronousQueue put errror!",e);
		}
		return false;
	}
	
	public String get(){
		String result = null;
		try{
			result = synchronousQueue.take();
		}catch(Exception e){
			log.error("synchronousQueue get errror!",e);
		}
		return result;
	}
	
	public static SynchronousQueueInitialize getInitialize(){
		return SynchronousQueueInitializeHolder.synchronousQueueInitialize_Holder;
	}
	
	private static class SynchronousQueueInitializeHolder{
		private static final SynchronousQueueInitialize synchronousQueueInitialize_Holder = new SynchronousQueueInitialize();
	}
	
}

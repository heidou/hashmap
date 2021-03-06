package mengka.queue.SynchronousQueue_01;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mengka.common.StringUtils;

import java.util.concurrent.SynchronousQueue;

/**
 *  移除操作take()必须等待生产者的插入操作put()
 *  <hr>
 *  【使用场景】：无限可扩展的线程池，根据需要（新任务到来时）才创建新的线程；
 *  <br>
 * Created by xiafeng
 * on 15-12-13.
 */
public class ConsumerTask implements Runnable {

    private static final Log log = LogFactory.getLog(ConsumerTask.class);

    private static final SynchronousQueueInitialize SYNCHRONOUS_QUEUE_INITIALIZE = SynchronousQueueInitialize.getInitialize();

    private SynchronousQueue<String> synchronousQueue;

    public ConsumerTask(){
    }

    public ConsumerTask(SynchronousQueue<String> synchronousQueue){
        this.synchronousQueue = synchronousQueue;
    }

    @Override
    public void run() {
    	log.info("-------------, ConsumerTask run..");
		process();
    }
    
    public void process() {
		try {
            while(true) {
                log.info("-------------, consumerTask process..");
                String content = SYNCHRONOUS_QUEUE_INITIALIZE.get();
                while (StringUtils.isNotBlank(content)) {
                    log.info(String.format("-------------, consumerTask get message = %s", content));
                    content = SYNCHRONOUS_QUEUE_INITIALIZE.get();
                }
            }
		} catch (Exception e) {
			log.error("process error!", e);
		}
	}
}

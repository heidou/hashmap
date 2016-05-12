package mengka.queue.SynchronousQueue_01;

import java.util.Date;
import java.util.concurrent.SynchronousQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mengka.common.TimeUtil;

/**
 * 插入操作put()必须等待消费者的移除操作take()
 * <hr>
 * 【使用场景】：无限可扩展的线程池，根据需要（新任务到来时）才创建新的线程； <br>
 * 
 * @author mengka.hyy
 * 
 */
public class ProducerTask implements Runnable {

	private static final Log log = LogFactory.getLog(ProducerTask.class);

	private static final SynchronousQueueInitialize SYNCHRONOUS_QUEUE_INITIALIZE = SynchronousQueueInitialize
			.getInitialize();

	private static final String test_message = "%s-mengka AAA...[%s]";

	private long time;

	private SynchronousQueue<String> synchronousQueue;

	public ProducerTask(long time){
		this.time = time;
	}

	public ProducerTask(SynchronousQueue<String> synchronousQueue,long time){
		this.time = time;
		this.synchronousQueue = synchronousQueue;
	}

	@Override
	public void run() {
		log.info("-------------, ProducerTask run..");
		process();
	}

	public void process() {
		try {
			while (true) {
				String content = String.format(test_message,
						Thread.currentThread().getName(),TimeUtil.toDate(new Date(), TimeUtil.format_1));
				log.info(String.format("producerTask send message = %s", content));
				SYNCHRONOUS_QUEUE_INITIALIZE.add(content);
				Thread.sleep(this.time);
			}
		} catch (Exception e) {
			log.error("process error!", e);
		}
	}

}

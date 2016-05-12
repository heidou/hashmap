package mengka.queue.SynchronousQueue_02;

import com.mengka.common.TimeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;

/**
 * �������put()����ȴ������ߵ��Ƴ�����take()
 * <hr>
 * ��ʹ�ó����������޿���չ���̳߳أ�������Ҫ����������ʱ���Ŵ����µ��̣߳� <br>
 * 
 * @author mengka.hyy
 * 
 */
public class ProducerTask implements Runnable {

	private static final Log log = LogFactory.getLog(ProducerTask.class);

	private static final String test_message = "[%s] - mengka AAA...[%s]";

	private long time;

	private SynchronousQueue<String> synchronousQueue;

	public ProducerTask(SynchronousQueue<String> synchronousQueue, long time){
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
				synchronousQueue.put(content);
				Thread.sleep(this.time);
			}
		} catch (Exception e) {
			log.error("process error!", e);
		}
	}

}

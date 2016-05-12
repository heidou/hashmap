package mengka.queue.SynchronousQueue_02;

import com.mengka.common.TimeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by xiafeng
 * on 15-12-13.
 */
public class Taa {

    private static final Log log = LogFactory.getLog(Taa.class);

    private static final String test_message = "[%s] - mengka AAA...[%s]";

    public static void main(String[] args)throws Exception{
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();

        Thread consumerTask = new Thread(new ConsumerTask(synchronousQueue));
        consumerTask.start();

        for(int i=0;i<10;i++){
            String content = String.format(test_message,
                    Thread.currentThread().getName(), TimeUtil.toDate(new Date(), TimeUtil.format_1));
            synchronousQueue.put(content);
            Thread.sleep(2000);
        }

        log.info("taa test end...");
    }
}

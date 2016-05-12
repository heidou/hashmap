package mengka.queue.SynchronousQueue_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiafeng
 * on 15-12-13.
 */
public class start_consumer {

    private static final Log log = LogFactory.getLog(start_consumer.class);

    public static void main(String[] args){
//        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread consumerTask = new Thread(new ConsumerTask(),"consumer No1");
        log.info("threadPool submit thread = "+consumerTask.getName());
        consumerTask.start();
//        executorService.execute(consumerTask);

//        executorService.shutdown();
//        log.info("threadPool shutdown..");
    }
}

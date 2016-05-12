package mengka.queue.SynchronousQueue_02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by xiafeng
 * on 15-12-13.
 */
public class Tbb {

    private static final Log log = LogFactory.getLog(Tbb.class);

    public static void main(String[] args){
        log.info("tbb test run...");
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread producerTask1 = new Thread(new ProducerTask(synchronousQueue,2000),"p-thread-1");
//        producerTask1.start();

        Thread producerTask2 = new Thread(new ProducerTask(synchronousQueue,10000),"p-thread-2");
//        producerTask2.start();

        Thread consumerTask = new Thread(new ConsumerTask(synchronousQueue));
//        consumerTask.start();

        executorService.submit(producerTask1);
        executorService.submit(producerTask2);
        executorService.submit(consumerTask);
        log.info("tbb test end...");
        executorService.shutdown();
    }
}

package mengka.queue.SynchronousQueue_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiafeng
 * on 15-12-13.
 */
public class start_producer {

    private static final Log log = LogFactory.getLog(start_producer.class);

    public static void main(String[] args){
//        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread producerTask1 = new Thread(new ProducerTask(2000),"producer No1");
//        Thread producerTask2 = new Thread(new ProducerTask(2000),"producer No2");
        log.info("threadPool submit thread = "+producerTask1.getName());
//        log.info("threadPool submit thread = " + producerTask2.getName());
        producerTask1.start();
//        producerTask2.run();
//        executorService.execute(producerTask1);
//        executorService.execute(producerTask2);

//        executorService.shutdown();
//        log.info("threadPool shutdown..");
    }
}

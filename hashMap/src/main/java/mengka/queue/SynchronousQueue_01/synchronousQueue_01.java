package mengka.queue.SynchronousQueue_01;

import com.mengka.common.TimeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;

/**
 * synchronousQueue，没有缓冲的BlockingQueue
 * <ul>
 *   <li>生产者线程对其的插入操作put，必须等待消费者的移动操作take；【反过来也是一样】</li>
 *   <li>SynchronousQueue内部没有数据缓冲空间，因为数据元素只有在你试着取走的时候才可能存在；</li>
 *   <li>数据是在配对的生产者和消费者线程之间直接传递的；【不会缓冲数据到队列中】</li>
 * </ul>
 * <hr>
 * 【例①：使用场景】<br>
 * Executors.newCachedThreadPool();<br>
 * <br>
 * 》》这个线程池，根据需要（新任务到来时）创建新的线程，如果有空闲线程则会重复使用；<br>
 * 》》线程空闲了60s后会被回收；<br>
 * <br>
 * <ul>
 *   <li>无限可扩展的线程池，在需求量减少的时候会减少线程数；</li>
 *   <li><font color="red">【可扩展】【更好的队列等候性能，SynchronousQueue】;</font></li>
 *   <li>【参数】：最大池大小 = Integer.MAX_VALUE = 0x7fffffff = 2^31 - 1 ＝ 2147483647；</li>
 *   <li>【参数】：核心池大小 = 0；</li>
 *   <li>【参数】：超时时间 = 1min；</li>
 * </ul>
 * 
 * Created by xiafeng
 * on 15-11-14.
 */
public class synchronousQueue_01 {

    private static final Log log = LogFactory.getLog(synchronousQueue_01.class);

    public static void main(String[] args)throws Exception{
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();


        synchronousQueue.put(getContent());

        String content = synchronousQueue.poll();
        log.info("take content = "+content);



        boolean isTakeBlock = synchronousQueue.offer(getContent());
        log.info("-------------, isTakeBlock = "+isTakeBlock);


        String takeContent;
        while((takeContent=synchronousQueue.take())!=null){
            log.info("takeContent = "+takeContent);
        }

        isTakeBlock = synchronousQueue.offer(getContent());
        log.info("-------------, isTakeBlock = "+isTakeBlock);
    }

    public static String getContent(){
        return "mengka AAA.."+TimeUtil.toDate(new Date(),TimeUtil.format_1);
    }
}

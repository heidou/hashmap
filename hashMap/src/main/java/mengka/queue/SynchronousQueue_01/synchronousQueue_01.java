package mengka.queue.SynchronousQueue_01;

import com.mengka.common.TimeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;

/**
 * synchronousQueue��û�л����BlockingQueue
 * <ul>
 *   <li>�������̶߳���Ĳ������put������ȴ������ߵ��ƶ�����take����������Ҳ��һ����</li>
 *   <li>SynchronousQueue�ڲ�û�����ݻ���ռ䣬��Ϊ����Ԫ��ֻ����������ȡ�ߵ�ʱ��ſ��ܴ��ڣ�</li>
 *   <li>����������Ե������ߺ��������߳�֮��ֱ�Ӵ��ݵģ������Ỻ�����ݵ������С�</li>
 * </ul>
 * <hr>
 * �����٣�ʹ�ó�����<br>
 * Executors.newCachedThreadPool();<br>
 * <br>
 * ��������̳߳أ�������Ҫ����������ʱ�������µ��̣߳�����п����߳�����ظ�ʹ�ã�<br>
 * �����߳̿�����60s��ᱻ���գ�<br>
 * <br>
 * <ul>
 *   <li>���޿���չ���̳߳أ������������ٵ�ʱ�������߳�����</li>
 *   <li><font color="red">������չ�������õĶ��еȺ����ܣ�SynchronousQueue��;</font></li>
 *   <li>�������������ش�С = Integer.MAX_VALUE = 0x7fffffff = 2^31 - 1 �� 2147483647��</li>
 *   <li>�������������ĳش�С = 0��</li>
 *   <li>������������ʱʱ�� = 1min��</li>
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

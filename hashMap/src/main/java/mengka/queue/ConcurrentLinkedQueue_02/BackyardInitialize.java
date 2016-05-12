package mengka.queue.ConcurrentLinkedQueue_02;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *  ��Ժ�ľۻ���feed��ʼ�����ӻ����������ȡ
 * 
 * @author mengka.hyy
 *
 */
public class BackyardInitialize {

	private ConcurrentLinkedQueue<BackyardDO> queue = new ConcurrentLinkedQueue<BackyardDO>();

    public void initBackyard(BackyardDO backyardDO) {
        queue.add(backyardDO);
    }

    public BackyardDO get() {
        return queue.poll();
    }

    public ConcurrentLinkedQueue<BackyardDO> getQueue() {
        return queue;
    }
    
    public static BackyardInitialize getInitialize(){
        return BackyardInitializeHolder.tbjflowOpInitialize_Holder;
    }

    private static class BackyardInitializeHolder{
        private static final BackyardInitialize tbjflowOpInitialize_Holder = new BackyardInitialize();
    }
}

package mengka.concurrentHashMap_03;

/**
 *  ÿ���̶߳�����ӵ��һ��threadlocal�������������̰߳�ȫ���ִ�������ִ��Ч��
 * 
 * @author mengka.hyy
 *
 */
public class TaaTask implements Runnable {

	private Taa taa;
	
	public TaaTask(Taa taa) {
		this.taa = taa;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("thread[" + Thread.currentThread().getName()
					+ "] , mengka[" + taa.getNextNum() + "]");
			
			//System.out.println(taa.mengka.get());
		}
		Taa.latch.countDown();
	}

}

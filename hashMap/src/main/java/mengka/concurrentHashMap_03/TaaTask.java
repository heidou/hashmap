package mengka.concurrentHashMap_03;

/**
 *  每个线程都独立拥有一个threadlocal变量副本，即线程安全，又大大提高了执行效率
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

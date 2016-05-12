package mengka.atomicInteger_02;

/**
 *  �߳�2:��baicai������һ
 * 
 * @author mengka.hyy
 *
 */
public class DelTask implements Runnable{

	public String name;
	
	public DelTask(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		synchronized(Taa.baicai){
			Taa.delete();
			System.out.println(name+" , baicai = "+Taa.getBaicai());
			Taa.latch.countDown();
		}
	}

}

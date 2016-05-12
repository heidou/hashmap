package mengka.atomicInteger_02;

/**
 *  �߳�1:��baicai������һ
 * 
 * @author mengka.hyy
 *
 */
public class AddTask implements Runnable{

	public String name;
	
	public AddTask(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		synchronized(Taa.baicai){
			Taa.add();
			System.out.println(name + " , baicai = "+Taa.getBaicai());
			Taa.latch.countDown();
		}
	}

}

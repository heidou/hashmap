package mengka.atomicInteger_02;

/**
 *  线程1:对baicai变量加一
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

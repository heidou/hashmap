package mengka.atomicInteger_02;

/**
 *  线程2:对baicai变量减一
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

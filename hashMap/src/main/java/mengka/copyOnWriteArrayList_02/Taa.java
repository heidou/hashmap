package mengka.copyOnWriteArrayList_02;


import java.util.concurrent.CountDownLatch;

/**
 * 线程安全的List
 *  <br>
 *    测试仿造CopyOnWriteArrayList实现的MengkaList的多线程读写功能
 * 
 * @author mengka.hyy
 * 
 */
public class Taa {

	public static CountDownLatch latch = null;


	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception{

		Mengka mengka = new Mengka();
		
		
		// 保证4个线程同时执行
		latch = new CountDownLatch(130);

		long start = System.currentTimeMillis();

		for(int i=0;i<100;i++){
			new Thread(new AddTask("addTask["+i+"]",mengka)).start();
		}
		
		for(int i=0;i<30;i++){
			new Thread(new RemoveTask("removeTask["+i+"]",mengka)).start();
		}
		
		/**
		 *   保证所有的线程都执行完成后，才后执行后面的代码
		 */
		latch.await();		
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("endTime - start = "+(endTime - start));
		
		MengkaList<String> mengkaList = mengka.getMengkaList();
		for(int i=0;i<mengkaList.size();i++){
			System.out.println("mengka["+i+"] = "+mengkaList.get(i));
		}
		
	}

	
	
	
	
}

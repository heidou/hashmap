package mengka.copyOnWriteArrayList_02;

import java.io.PrintWriter;
import java.io.StringWriter;
import mengka.copyOnWriteArrayList_02.Taa;

public class AddTask implements Runnable{

	public String name;
	
	public Mengka mengka;
	
	public AddTask(String name,Mengka mengka){
		this.name = name;
		this.mengka = mengka;
	}
	
	@Override
	public void run() {
		try{
			Thread.sleep(2000);
			synchronized (mengka) {
				String content = name + " , baicai" + mengka.mengkaList.size();
				mengka.add(content);
				System.out.println("-------------- , " + content);
				Taa.latch.countDown();
			}
		}catch(Exception e){
			StringWriter writer = new StringWriter();
			PrintWriter s = new PrintWriter(writer);
			e.printStackTrace(s);
			System.out.println("-------------,#AddTask# error:"
					+ writer.toString());
		}
	}

}

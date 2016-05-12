package mengka.copyOnWriteArrayList_02;

import java.io.PrintWriter;
import java.io.StringWriter;

public class RemoveTask implements Runnable {

	public String name;
	
	public Mengka mengka;

	public RemoveTask(String name,Mengka mengka) {
		this.name = name;
		this.mengka = mengka;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1800);
			
			synchronized (mengka) {				
				int result = mengka.removeLastOne();
				System.out.println("---------- , " + name + " , result = "
						+ result);
				Taa.latch.countDown();
			}
		} catch (Exception e) {
			StringWriter writer = new StringWriter();
			PrintWriter s = new PrintWriter(writer);
			e.printStackTrace(s);
			System.out.println("-------------,#RemoveTask# error:"
					+ writer.toString());
		}
	}

}

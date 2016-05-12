package mengka.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class A implements Runnable{

	@Override
	public void run() {
		mkMengka(atomicInteger_01.mengka);
	}

	public void mkMengka(Mengka mengka){
		mengka.setMkCount(new AtomicInteger(30));
		System.out.println("t2: "+mengka.getMkCount());
	}
}

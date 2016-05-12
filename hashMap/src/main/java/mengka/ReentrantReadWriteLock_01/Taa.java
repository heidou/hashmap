package mengka.ReentrantReadWriteLock_01;

import java.util.HashMap;

/**
 *  【读写锁】：<br>
 *  一个资源能够被多个读者访问，或者被一个写者访问，两者不能同时运行；
 *  <br>
 *  读写锁用来进行性能改进的，在特定的情况下具有更好的并发性；<br>
 *  <br>
 *  》》优先处理写锁：<br>
 *  读者和写者同时请求锁，写者优先获得锁，写者被受理，并且释放写入锁后，读者才开始受理；<br>
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	public static void main(String[] args) throws Exception{
		
		ReadWriteMap<String, String> map = new ReadWriteMap<String, String>(new HashMap<String, String>());
		
		new Thread(new WriteTask(map)).start();
		new Thread(new ReadTask(map)).start();
		
	}

}

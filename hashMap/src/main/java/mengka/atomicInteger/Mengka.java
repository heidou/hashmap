package mengka.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;


/**
 *  <font color="red">【支持原子操作的Integer类】</font>  
 * 
 *  <hr>
 *  AtomicInteger利用内存，比较该ID是否已经存在，来实现并发访问ID<br><br>
 *  【CAS操作】：<br>
 *   CPU原语<br>
 *   由CPU比较内存位置上，值是否为当前值，无阻塞
 *  <hr>
 *  【例1】：<br>
 *  利用多线程获取一串ID
 *  <br><br>
 *  法①：<br>
 *    多线程下，每次获取时，都要进行加锁操作，避免并发时获取同样ID的情况；
 *    <br><br>
 *  法②：<br>
 *    采用atomicInteger,<font color="red">【比较内存】</font>  
 * 
 * @author mengka.hyy
 *
 */
public class Mengka {

	/**
	 *   atomicInteger的性能比同步锁要好
	 *    (法②)             (法①)
	 */
	public AtomicInteger mkCount;

	
	public AtomicInteger getMkCount() {
		return mkCount;
	}

	public void setMkCount(AtomicInteger mkCount) {
		this.mkCount = mkCount;
	}
	
	
}

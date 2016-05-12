package mengka.threadPoolExecutor_01;

/**
 * 【线程池满的时候的操作】：<br>
 * 
 * 
 * 
 * 1. 当n=corePoolSize时，交由调用者线程来执行;<br>
 * <br>
 * 
 * <font color="red">callerRunsPolicy</font><br>
 * <br>
 * 
 * 
 * 2. 当n=corePoolSize时，直接抛错;<br>
 * <br>
 * 
 * <font color="red">AbortPolicy</font><br>
 * <br>
 * 
 * 
 * 3. 当n=corePoolSize时，不做任何动作，<br>
 * <br>
 * 
 * <font color="red">DiscardPolicy</font> <br>
 * <br>
 * 
 * 
 * 4. 当n=corePoolSize时，抛弃最后一个任务，并执行新传入的Runnable任务;<br>
 * <br>
 * 
 * <font color="red">DiscardOldestPolicy</font> <br>
 * <br>
 * <hr>
 * 
 * @author mengka.hyy
 * 
 */
public class threadPoolExecutor_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package mengka.queue.arrayBlockingQueue;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 多线程，遍历path路径下面的文件，将文件放入大小为1000的阻塞队列里
 * <hr>
 * {@link ArrayBlockingQueue}是FIFO的阻塞队列：
 * <ul>
 * <li>poll():检索并移除此队列的头，如果此队列为空，则返回 null</li>
 * <li>take():检索并移除此队列的头部，如果此队列不存在任何元素，则一直等待。</li>
 * <li>peek():检索，但是不移除此队列的头，如果此队列为空，则返回 null。</li>
 * 
 * <li>put(E):将指定的元素添加到此队列的尾部，如果必要，将等待可用的空间。</li>
 * <li>offer(E o, long timeout, TimeUnit unit):
 * 将指定的元素插入到此队列的尾部，如果没有可用空间，将等待指定的等待时间（如果有必要）。</li>
 * </ul>
 *  <hr>
 *  基于固定大小的数组，可阻塞的先进先出Queue<br>
 *  容量可限制，可实现指定时间的阻塞读写<br>
 *  <font color="red">【线程安全，常被用于做线程池的任务缓冲队列】</font><br>
 *  线程池的支持的任务数的执行 = corePoolSize + BlockingQueue大小<br>
 * 
 * @author mengka.hyy
 * 
 */
public class A {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入路径：");
		String path = "F:\\work_hyy\\thread\\src\\main\\java";// scanner.nextLine();

		//大小为1000的阻塞队列
		BlockingQueue<File> blockingQueue = new ArrayBlockingQueue<File>(1000);

		/**
		 * 生产者：
		 *    将path下面的文件都放入到阻塞队列里面
		 */
		Thread t1 = new Thread(new FileRunnable(blockingQueue, new File(path)));
		t1.start();

		/**
		 * 10个消费者：
		 *    从阻塞队列里面，取出队头，如果是"Ball.java"，则返回结果
		 */
		for(int i=0;i<10;i++){
			Thread t2 = new Thread(new FileFoundRunnable(blockingQueue, "Ball.java"));
			t2.start();
		}
		
		System.out.println("blockQueue size = "+blockingQueue.size());
	}
}

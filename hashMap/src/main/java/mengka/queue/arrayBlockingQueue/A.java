package mengka.queue.arrayBlockingQueue;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ���̣߳�����path·��������ļ������ļ������СΪ1000������������
 * <hr>
 * {@link ArrayBlockingQueue}��FIFO���������У�
 * <ul>
 * <li>poll():�������Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null</li>
 * <li>take():�������Ƴ��˶��е�ͷ��������˶��в������κ�Ԫ�أ���һֱ�ȴ���</li>
 * <li>peek():���������ǲ��Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null��</li>
 * 
 * <li>put(E):��ָ����Ԫ����ӵ��˶��е�β���������Ҫ�����ȴ����õĿռ䡣</li>
 * <li>offer(E o, long timeout, TimeUnit unit):
 * ��ָ����Ԫ�ز��뵽�˶��е�β�������û�п��ÿռ䣬���ȴ�ָ���ĵȴ�ʱ�䣨����б�Ҫ����</li>
 * </ul>
 *  <hr>
 *  ���ڹ̶���С�����飬���������Ƚ��ȳ�Queue<br>
 *  ���������ƣ���ʵ��ָ��ʱ���������д<br>
 *  <font color="red">���̰߳�ȫ�������������̳߳ص����񻺳���С�</font><br>
 *  �̳߳ص�֧�ֵ���������ִ�� = corePoolSize + BlockingQueue��С<br>
 * 
 * @author mengka.hyy
 * 
 */
public class A {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Scanner scanner = new Scanner(System.in);
		System.out.println("������·����");
		String path = "F:\\work_hyy\\thread\\src\\main\\java";// scanner.nextLine();

		//��СΪ1000����������
		BlockingQueue<File> blockingQueue = new ArrayBlockingQueue<File>(1000);

		/**
		 * �����ߣ�
		 *    ��path������ļ������뵽������������
		 */
		Thread t1 = new Thread(new FileRunnable(blockingQueue, new File(path)));
		t1.start();

		/**
		 * 10�������ߣ�
		 *    �������������棬ȡ����ͷ�������"Ball.java"���򷵻ؽ��
		 */
		for(int i=0;i<10;i++){
			Thread t2 = new Thread(new FileFoundRunnable(blockingQueue, "Ball.java"));
			t2.start();
		}
		
		System.out.println("blockQueue size = "+blockingQueue.size());
	}
}

package mengka.queue.arrayBlockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 *  ��queue�����ҳ�name��Ӧ���ļ�
 *  <hr>
 *  <ul>
 *     <li>��������ǿյģ�һ����ȡ������һֱ�����������д��ڿ���Ԫ�أ�</li>
 *     <li>������������ģ����������һֱ�������е������д��ڿ��ÿռ䣻</li>
 *  </ul>
 * 
 * @author mengka.hyy
 *
 */
public class FileFoundRunnable implements Runnable{

	public BlockingQueue<File> blockingQueue;
	public String name;
	public static int n=0;
	
	public FileFoundRunnable(BlockingQueue<File> blockingQueue,String name) {
		this.blockingQueue = blockingQueue;
		this.name = name;
	}
	
	@Override
	public void run() {
		try{
			boolean hasFound = false;
			while(!hasFound){
				File file = blockingQueue.take();
				if(file.getName().equals(name)){
					hasFound = true;
					System.out.println("find princess file!! , size = "+blockingQueue.size());
					System.exit(0);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package mengka.queue.arrayBlockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 *  从queue里面找出name对应的文件
 *  <hr>
 *  <ul>
 *     <li>如果队列是空的，一个获取操作会一直阻塞到队列中存在可用元素；</li>
 *     <li>如果队列是满的，插入操作会一直阻塞队列到队列中存在可用空间；</li>
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

package mengka.queue.arrayBlockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 安全阻塞队列：<br>
 * 读取路径下面的所有文件
 * 
 * @author mengka.hyy
 * 
 */
public class FileRunnable implements Runnable {

	public static File file1 = new File("");
	public BlockingQueue<File> blockingQueue;
	private File file2;
	private static int n = 0;
	
	public FileRunnable(BlockingQueue<File> bq,File file2) {
		this.blockingQueue = bq;
		this.file2 = file2;
	}
	
	@Override
	public void run() {
		try {
			putFileList(file2);
			blockingQueue.put(file1);
		} catch (Exception e) {
			System.out.println("FileRunnable error: "+e);
			e.printStackTrace();
		}	
	}

	/**
	 *  递归遍历当前路径下的所有文件，并将文件put到阻塞队列里
	 * 
	 * @param file 当前的文件路径
	 * @throws Exception
	 */
	public void putFileList(File file) throws Exception{
		File[] aaFiles = file.listFiles();
		for(File tmpFile:aaFiles){
			try{
				if(tmpFile.isDirectory()){
					if(".svn".equals(tmpFile.getName())){
						continue;
					}
					System.out.println("directory: "+tmpFile.getName());
					putFileList(tmpFile);
				}else{
					System.out.println("n = "+(++n)+" , size = "+blockingQueue.size()+" , file: "+tmpFile.getName());
					blockingQueue.put(tmpFile);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

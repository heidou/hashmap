package mengka.queue.arrayBlockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * ��ȫ�������У�<br>
 * ��ȡ·������������ļ�
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
	 *  �ݹ������ǰ·���µ������ļ��������ļ�put������������
	 * 
	 * @param file ��ǰ���ļ�·��
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

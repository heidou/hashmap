package mengka.array_01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 *  利用像素数组copy的方法,<br>
 *   下载图片URL，对应的图片到本地的制定文件夹里面
 * 
 * @author mengka.hyy
 *
 */
public class arrayCopy_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		
		String urlString="http://img02.taobaocdn.com/imgextra/i7/T1wP3oXiNaXXbGKWs.";
		String fileString = "D:/newDownload/mengka.jpg";
		
		downPicture2File(urlString, fileString);
		
		
	}
	
	
	
	/**
	 *  将图片urlString下载到制定的位置file
	 * 
	 * @param urlString
	 * @param file
	 */
	public static void downPicture2File(String urlString,String file)throws Exception{
		
		URL url = new URL(urlString);
		InputStream inputStream = url.openStream();
			
		//图片必须小于5M
		byte[] inBytes = new byte[5*1024*1024];
		int picLen = inputStream.read(inBytes);
		if (picLen == -1) {
		  throw new Exception("读取失败");
		}
		byte[] outBytes = new byte[picLen];
		/**
		 *  将inBytes的[0,picLen],复制到outBytes
		 */
		System.arraycopy(inBytes, 0, outBytes, 0, picLen);

		File outFile = new File(file);
		OutputStream os = new FileOutputStream(outFile);
		os.write(outBytes);
	}

}

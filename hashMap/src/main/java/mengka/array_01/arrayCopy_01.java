package mengka.array_01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 *  ������������copy�ķ���,<br>
 *   ����ͼƬURL����Ӧ��ͼƬ�����ص��ƶ��ļ�������
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
	 *  ��ͼƬurlString���ص��ƶ���λ��file
	 * 
	 * @param urlString
	 * @param file
	 */
	public static void downPicture2File(String urlString,String file)throws Exception{
		
		URL url = new URL(urlString);
		InputStream inputStream = url.openStream();
			
		//ͼƬ����С��5M
		byte[] inBytes = new byte[5*1024*1024];
		int picLen = inputStream.read(inBytes);
		if (picLen == -1) {
		  throw new Exception("��ȡʧ��");
		}
		byte[] outBytes = new byte[picLen];
		/**
		 *  ��inBytes��[0,picLen],���Ƶ�outBytes
		 */
		System.arraycopy(inBytes, 0, outBytes, 0, picLen);

		File outFile = new File(file);
		OutputStream os = new FileOutputStream(outFile);
		os.write(outBytes);
	}

}

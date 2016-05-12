package mengka.byteBuffer_01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

/**
 *  ByteBuffer��allocate��allocateDirect,���־�̬ʵ����ʽ������
 * <ul>
 *   <li>
 *      allocate(),��һ�ַ��䷽ʽ�������ڴ濪����<font color="red">����JVM�з��䡿</font>��;<br>
 *      ��ʱ,��Java������յ��ⲿ����������ʱ�������Ǳ�ϵͳ�ڴ�����ȡ��Ȼ������ϵͳ�ڴ渴�ƿ�����JVM�ڴ��й�Java����ʹ�á�<br>
 *      �����ڵڶ��ַ��䷽ʽ�У�����ʡȥ������һ��������Ч���ϻ�������ߡ�
 *   </li>
 *   <li>
 *      allocateDirect(),�ڶ��ֵķ��䷽ʽ�����Ŀ�����JVM֮�⣬�Ծ���<font color="red">��ϵͳ�����ڴ���䡿</font>;<br>
 *      ��Ȼ��ϵͳ�ڴ�����JVM�ڴ������ȥ��һ�θ��ƵĲ��������ǣ�ϵͳ���ڴ�ķ������JVM�ڴ�ķ���Ҫ��ʱ�öࣻ<br>
 *      ���ԣ�������С��ʱ��allocateDirect()�Ĳ���Ч�ʲ����û�Ƚϸߣ�
 *   </li>
 * </ul>
 * <hr>
 * ��ͼ���Կ�������������������Сʱ�����ַ��䷽ʽ����ʹ��ʱ���������ͬ�ģ���һ�ַ�ʽ��ʱ���ܻ���죬���ǵ��������ܴ�ʱ���ڶ��ַ�ʽ��ԶԶ���ڵ�һ�ֵķ��䷽ʽ��
 * <img src="http://s5.sinaimg.cn/mw690/67dc1100gd9718eea7ad4&690">
 * 
 * @author mengka.hyy
 *
 */
public class byteBuffer_02 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		/**
		 * step01:
		 *    ��ȡ����
		 */
		String path = "src//main//java//mengka//byteBuffer_01//aa.txt";
		String kkString=mkFileAllRead(path);
		
		/**
		 * step02:
		 *    ʹ��allocate(int capacity)��Ҫ��ʱ��
		 */
		long start1 = System.currentTimeMillis();
		
		test_allocate(kkString);
		
		long endTime1 = System.currentTimeMillis();
		System.out.println("test_allocate , endTime - start = "+(endTime1 - start1));

		
		long start2 = System.currentTimeMillis();
		
		test_allocateDirect(kkString);
		
		long endTime2 = System.currentTimeMillis();
		System.out.println("test_allocateDirect , endTime - start = "+(endTime2 - start2));
	}
	
	
	public static void test_allocateDirect(String bbString) throws Exception{
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);//����һ������Ϊ256�ֽڵĻ�����
		buffer.put(bbString.getBytes("gbk"));
		
		buffer.flip();// ����flip()ʹlimit��Ϊ��ǰ��position��ֵ,position��Ϊ0
		byte[] result = new byte[buffer.limit()];
		buffer.get(result); //��ByteBuffer�ж�ȡ���ݵ�byte������
		
//		System.out.println(new String(result));
		buffer.clear();
    }
	
    public static void test_allocate(String bbString) throws Exception{
		ByteBuffer buffer = ByteBuffer.allocate(1024);//����һ������Ϊ256�ֽڵĻ�����
		buffer.put(bbString.getBytes("gbk"));
		
		buffer.flip();// ����flip()ʹlimit��Ϊ��ǰ��position��ֵ,position��Ϊ0
		byte[] result = new byte[buffer.limit()];
		buffer.get(result); //��ByteBuffer�ж�ȡ���ݵ�byte������
		
//		System.out.println(new String(result));
		buffer.clear();
    }

    
    /**
	 * ��ȡ�����ļ�
	 * 
	 * @param pathString  �ļ�������·��
	 */
	public static String mkFileAllRead(String pathString) {
		String kkString = "";
		StringBuffer stringBuffer = new StringBuffer();
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(
					new FileInputStream(pathString));
			BufferedReader brReader = new BufferedReader(inputStreamReader);
			stringBuffer = new StringBuffer();
			int str;
			while ((str = brReader.read()) != -1) {
				stringBuffer.append((char) str);
			}
			kkString = stringBuffer.toString();
		} catch (Exception e) {
			kkString = e.toString();
		}
		return kkString;
	}
}

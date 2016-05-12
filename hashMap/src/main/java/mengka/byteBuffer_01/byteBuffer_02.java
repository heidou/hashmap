package mengka.byteBuffer_01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

/**
 *  ByteBuffer的allocate和allocateDirect,两种静态实例方式的区别
 * <ul>
 *   <li>
 *      allocate(),第一种分配方式产生的内存开销是<font color="red">【在JVM中分配】</font>的;<br>
 *      这时,当Java程序接收到外部传来的数据时，首先是被系统内存所获取，然后在由系统内存复制拷贝到JVM内存中供Java程序使用。<br>
 *      所以在第二种分配方式中，可以省去复制这一步操作，效率上会有所提高。
 *   </li>
 *   <li>
 *      allocateDirect(),第二种的分配方式产生的开销在JVM之外，以就是<font color="red">【系统级的内存分配】</font>;<br>
 *      虽然，系统内存分配比JVM内存分配少去了一次复制的操作，但是，系统级内存的分配比起JVM内存的分配要耗时得多；<br>
 *      所以，在数据小的时候，allocateDirect()的操作效率不见得会比较高；
 *   </li>
 * </ul>
 * <hr>
 * 由图可以看出，当操作数据量很小时，两种分配方式操作使用时间基本是相同的，第一种方式有时可能会更快，但是当数据量很大时，第二种方式会远远大于第一种的分配方式。
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
		 *    读取数据
		 */
		String path = "src//main//java//mengka//byteBuffer_01//aa.txt";
		String kkString=mkFileAllRead(path);
		
		/**
		 * step02:
		 *    使用allocate(int capacity)需要的时间
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
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);//创建一个容量为256字节的缓冲区
		buffer.put(bbString.getBytes("gbk"));
		
		buffer.flip();// 调用flip()使limit变为当前的position的值,position变为0
		byte[] result = new byte[buffer.limit()];
		buffer.get(result); //从ByteBuffer中读取数据到byte数组中
		
//		System.out.println(new String(result));
		buffer.clear();
    }
	
    public static void test_allocate(String bbString) throws Exception{
		ByteBuffer buffer = ByteBuffer.allocate(1024);//创建一个容量为256字节的缓冲区
		buffer.put(bbString.getBytes("gbk"));
		
		buffer.flip();// 调用flip()使limit变为当前的position的值,position变为0
		byte[] result = new byte[buffer.limit()];
		buffer.get(result); //从ByteBuffer中读取数据到byte数组中
		
//		System.out.println(new String(result));
		buffer.clear();
    }

    
    /**
	 * 读取整个文件
	 * 
	 * @param pathString  文件的输入路径
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

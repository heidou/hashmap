package mengka.byteBuffer_01;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 *  byteBuffer的使用
 * 
 * @author mengka.hyy
 *
 */
public class String2byteBuffer_01 {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {

		/**
		 * 【例一】：
		 *    ByteBuffer.allocate(256);
		 *    将String变成byteBuffer，然后再获取byteBuffer里面的字符串
		 */
		String bbString = "大白菜BBB";
		ByteBuffer buffer = ByteBuffer.allocate(256);//创建一个容量为256字节的缓冲区
		buffer.put(bbString.getBytes("gbk"));
		
		buffer.flip();// 调用flip()使limit变为当前的position的值,position变为0
		byte[] result = new byte[buffer.limit()];
		buffer.get(result); //从ByteBuffer中读取数据到byte数组中
		
		System.out.println(new String(result));
		buffer.clear();
		
		
		/**
		 * 【例二】：
		 *   ByteBuffer.wrap();
		 *   将String变成byteBuffer，然后再获取byteBuffer里面的字符串
		 */
		String aaString = "大白菜AAA";
		ByteBuffer aaBuffer=ByteBuffer.wrap(aaString.getBytes("gbk"));
		System.out.println(new String(aaBuffer.array()));
	}

	/**
	 *  将ByteBuffer转化为string
	 *
	 * @param buffer
	 * @return
	 */
	public static String byteBuffer2String(ByteBuffer buffer){
		byte[] result = new byte[buffer.limit()];
		buffer.get(result); //从ByteBuffer中读取数据到byte数组中
		return new String(result);
	}

}

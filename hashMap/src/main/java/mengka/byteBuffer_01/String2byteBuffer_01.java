package mengka.byteBuffer_01;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 *  byteBuffer��ʹ��
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
		 * ����һ����
		 *    ByteBuffer.allocate(256);
		 *    ��String���byteBuffer��Ȼ���ٻ�ȡbyteBuffer������ַ���
		 */
		String bbString = "��ײ�BBB";
		ByteBuffer buffer = ByteBuffer.allocate(256);//����һ������Ϊ256�ֽڵĻ�����
		buffer.put(bbString.getBytes("gbk"));
		
		buffer.flip();// ����flip()ʹlimit��Ϊ��ǰ��position��ֵ,position��Ϊ0
		byte[] result = new byte[buffer.limit()];
		buffer.get(result); //��ByteBuffer�ж�ȡ���ݵ�byte������
		
		System.out.println(new String(result));
		buffer.clear();
		
		
		/**
		 * ����������
		 *   ByteBuffer.wrap();
		 *   ��String���byteBuffer��Ȼ���ٻ�ȡbyteBuffer������ַ���
		 */
		String aaString = "��ײ�AAA";
		ByteBuffer aaBuffer=ByteBuffer.wrap(aaString.getBytes("gbk"));
		System.out.println(new String(aaBuffer.array()));
	}

	/**
	 *  ��ByteBufferת��Ϊstring
	 *
	 * @param buffer
	 * @return
	 */
	public static String byteBuffer2String(ByteBuffer buffer){
		byte[] result = new byte[buffer.limit()];
		buffer.get(result); //��ByteBuffer�ж�ȡ���ݵ�byte������
		return new String(result);
	}

}

package mengka.stringBuffer_02;

public class stringBuffer_02 {

	public static void main(String[] args) {
		
		/**
		 *  stringBuffer���ַ������������ַ���
		 * 
		 */
		StringBuffer buffer = new StringBuffer();
		buffer.append("1");
		
		buffer.append("2", 0, 1);
		
		System.out.println(buffer.toString());
	}

}

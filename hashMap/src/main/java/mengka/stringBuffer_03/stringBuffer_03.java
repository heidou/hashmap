package mengka.stringBuffer_03;

/**
 *  StringBuffer���ַ��ǿɱ�ģ�����������̬�޸�����
 * 
 * @author mengka.hyy
 *
 */
public class stringBuffer_03 {

	public static void main(String[] args) {

		final StringBuffer buffer = new StringBuffer().append("abc");
		buffer.append("def");

		System.out.print(buffer.toString());

	}

}

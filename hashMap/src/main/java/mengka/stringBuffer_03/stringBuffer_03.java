package mengka.stringBuffer_03;

/**
 *  StringBuffer的字符是可变的，可以用来动态修改数据
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

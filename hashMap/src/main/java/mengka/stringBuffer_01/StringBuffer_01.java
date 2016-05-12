package mengka.stringBuffer_01;

/**
 * 
 * @author mengka.hyy
 *
 */
public class StringBuffer_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * 【例一】：
		 *    String和StringBuffer的区别
		 */
		StringBuffer aaBuffer = new StringBuffer();
		aaBuffer.append("大白菜");
		aaBuffer.append("大青菜");
		System.out.println(aaBuffer.toString());
		
		
		/**
		 * 【例二】:
		 *  final String，不可进行修改；
		 *  final StringBuffer，可以对提供字符串进行修改；
		 */
		final StringBuffer bbBuffer = new StringBuffer().append("大白菜AAA");
		bbBuffer.append("大青菜");
		System.out.println(bbBuffer.toString());
		
		
		final String aaString = "大白菜";
//		aaString=aaString+"大青菜";
		System.out.println(aaString);
	}

}

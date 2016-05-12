package mengka.MessageFormat_01;

import java.text.MessageFormat;

/**
 *  【MessageFormat的使用】：<br>
 *    String aa="白菜";<br>
 *    String bb="AAA";<br>
 *    String aaBaicai = MessageFormat.format("{0}:{1}",aa,bb);<br>
 *    <HR>
 *    》》 白菜：AAA
 * 
 * @author Administrator
 *
 */
public class MessageFormat_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		/**
		 *  【例①】：
		 *      将参数变量，结合到String里面
		 */
		String aaBaicai = "白菜AAAA";
		String bbBaicai = "白菜BBB";
		String ccBaicai = "白菜CCC";
		String ddBaicai = "白菜CCC";
		String wwBaicai = "白菜WWW";
		
		String content = MessageFormat
				.format("<!-- 渲染异常  widgetid={0} cmpId={1} cmpName={2} cmpTitle={3},exception={4}-->",
						aaBaicai,bbBaicai,ccBaicai,ddBaicai,wwBaicai);
		
		System.out.println(content);
		
		
		System.out.println("\n\n=======================\n");
		
		/**
		 *  【例②】：
		 *      参数变量是數組
		 */
		 int fileCount = 1273;
		 String diskName = "白菜";
		 
		 Object[] aaShuzu = {new Long(fileCount), diskName};

		
		  MessageFormat form = new MessageFormat(
		     "The disk \"{1}\" contains {0} file(s).");

		 //数组
		 System.out.println(form.format(aaShuzu));

		
	}
}

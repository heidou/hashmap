package mengka.MessageFormat_01;

import java.text.MessageFormat;

/**
 *  ��MessageFormat��ʹ�á���<br>
 *    String aa="�ײ�";<br>
 *    String bb="AAA";<br>
 *    String aaBaicai = MessageFormat.format("{0}:{1}",aa,bb);<br>
 *    <HR>
 *    ���� �ײˣ�AAA
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
		 *  �����١���
		 *      ��������������ϵ�String����
		 */
		String aaBaicai = "�ײ�AAAA";
		String bbBaicai = "�ײ�BBB";
		String ccBaicai = "�ײ�CCC";
		String ddBaicai = "�ײ�CCC";
		String wwBaicai = "�ײ�WWW";
		
		String content = MessageFormat
				.format("<!-- ��Ⱦ�쳣  widgetid={0} cmpId={1} cmpName={2} cmpTitle={3},exception={4}-->",
						aaBaicai,bbBaicai,ccBaicai,ddBaicai,wwBaicai);
		
		System.out.println(content);
		
		
		System.out.println("\n\n=======================\n");
		
		/**
		 *  �����ڡ���
		 *      ���������ǔ��M
		 */
		 int fileCount = 1273;
		 String diskName = "�ײ�";
		 
		 Object[] aaShuzu = {new Long(fileCount), diskName};

		
		  MessageFormat form = new MessageFormat(
		     "The disk \"{1}\" contains {0} file(s).");

		 //����
		 System.out.println(form.format(aaShuzu));

		
	}
}

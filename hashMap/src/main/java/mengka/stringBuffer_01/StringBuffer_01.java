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
		 * ����һ����
		 *    String��StringBuffer������
		 */
		StringBuffer aaBuffer = new StringBuffer();
		aaBuffer.append("��ײ�");
		aaBuffer.append("�����");
		System.out.println(aaBuffer.toString());
		
		
		/**
		 * ��������:
		 *  final String�����ɽ����޸ģ�
		 *  final StringBuffer�����Զ��ṩ�ַ��������޸ģ�
		 */
		final StringBuffer bbBuffer = new StringBuffer().append("��ײ�AAA");
		bbBuffer.append("�����");
		System.out.println(bbBuffer.toString());
		
		
		final String aaString = "��ײ�";
//		aaString=aaString+"�����";
		System.out.println(aaString);
	}

}

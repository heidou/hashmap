package mengka.vector;

import java.util.Enumeration;
import java.util.Vector;

public class vector_01 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		//������
		Vector aaVector=new Vector();
		aaVector.add("baicai");
		aaVector.add("qingcai");
		aaVector.add("xigua");
		aaVector.add(new Integer(22));
		
		System.out.println(aaVector);
		
		
		/**
		 *  ָ��index������Ԫ��
		 */
		aaVector.insertElementAt("���", 2);
		
		System.out.println(aaVector);
	
				
		/**
		 *  ָ��index��ɾ��Ԫ��
		 */
		aaVector.removeElementAt(1);
		
		System.out.println(aaVector);
		
		
		/**
		 * �����١��� 
		 *     ˳�ӣ�ö���࣬��ʾ����Ԫ��
		 */
		Enumeration enumeration = aaVector.elements();
		while(enumeration.hasMoreElements()){
			Object object = enumeration.nextElement();
			System.out.println(object);
		}
		
		
		/**
		 * �����ڡ���
		 *      ö���г�����Ԫ��
		 */
		for (Enumeration e = aaVector.elements(); e.hasMoreElements();)
		       System.out.println(e.nextElement());
	}

}

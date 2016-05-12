package mengka.transient_01;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.mengka.common.JsonUtil;

/**
 *  
 *  ����ʵ����serilizable�ӿڣ�������Щ���Բ��뱻���л������磺���롢���п���������Ϣ����ϣ���������б����䣩
 * 
 * @author mengka.hyy
 *
 */
public class transient_01 {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception{
		Mengka mengka = new Mengka();
		mengka.setId(044101331);
		mengka.setBaicai("baicaiAAA");
		mengka.setQingcai("qingcaiAAA");//transient����
		mengka.setMengka("mengka test");
		
		/**
		 * ��һ��
		 *  json = {"id":9470681,"baicai":"baicaiAAA","qingcai":"qingcaiAAA"}
		 * 
		 *  static����mengkaû�г��֣�
		 */
		String jsonString = JsonUtil.toJson(mengka);
		System.out.println("json = "+jsonString);
		
		/**
		 * ������
		 *    mengka = mengka.transient_01.Mengka@fcfa52[id=9470681,baicai=baicaiAAA]
		 *  
		 *  transient����qingcai��û�г��֣�
		 *  static����mengkaû�г��֣�
		 */
		Mengka bbMengka = (Mengka) JsonUtil.parseJson(jsonString, Mengka.class);
		
		Mengka.mengka = "jvm-mengka��static����ȡ����jvm��������ݣ������л�������û�й�ϵ";
		System.out.println("jvm-mengka = "+bbMengka.getMengka());
		String logString = ToStringBuilder.reflectionToString(bbMengka);
		System.out.println("mengka = "+logString);
	}

}

package mengka.transient_01;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.mengka.common.JsonUtil;

/**
 *  
 *  对象实现了serilizable接口，但是有些属性不想被序列化（例如：密码、银行卡等敏感信息，不希望在网络中被传输）
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
		mengka.setQingcai("qingcaiAAA");//transient变量
		mengka.setMengka("mengka test");
		
		/**
		 * 例一：
		 *  json = {"id":9470681,"baicai":"baicaiAAA","qingcai":"qingcaiAAA"}
		 * 
		 *  static变量mengka没有出现；
		 */
		String jsonString = JsonUtil.toJson(mengka);
		System.out.println("json = "+jsonString);
		
		/**
		 * 例二：
		 *    mengka = mengka.transient_01.Mengka@fcfa52[id=9470681,baicai=baicaiAAA]
		 *  
		 *  transient变量qingcai，没有出现；
		 *  static变量mengka没有出现；
		 */
		Mengka bbMengka = (Mengka) JsonUtil.parseJson(jsonString, Mengka.class);
		
		Mengka.mengka = "jvm-mengka，static变量取的是jvm里面的数据，和序列化的数据没有关系";
		System.out.println("jvm-mengka = "+bbMengka.getMengka());
		String logString = ToStringBuilder.reflectionToString(bbMengka);
		System.out.println("mengka = "+logString);
	}

}

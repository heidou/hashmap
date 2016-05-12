package mengka.transient_02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.lang.builder.ToStringBuilder;
import mengka.transient_01.Mengka;

/**
 *  transient使用
 *  <hr>
 *  <ul>
 *  <li>transient变量没有参与序列化，没有被传输；</li>
 *  <li>static变量是在内存中的，所以也不会参与序列化；</li>
 *  </ul>
 * 
 * @author mengka.hyy
 *
 */
public class transient_02 {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {

		Mengka mengka = new Mengka();
		mengka.setId(044101331);
		mengka.setBaicai("baicaiAAA");
		mengka.setQingcai("qingcaiAAA");// transient变量
		mengka.setMengka("mengka test");

		/**
		 * 将mengka对象写入文件中
		 * 
		 */
		String path = "/Users/hyy044101331/work_hyy/hashMap/src/main/java/mengka/transient_02/data.txt";
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(
				path));
		os.writeObject(mengka); // 将mengka对象写进文件
		os.flush();
		os.close();

		/**
		 * 从文件中读取mengka对象
		 * 
		 */
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
		Mengka bbMengka = (Mengka) is.readObject(); // 从流中读取User的数据
		is.close();

		/**
		 * id = 9470681<br>
		 * baicai = baicaiAAA<br>
		 * qingcai = null（transient变量没有参与序列化）<br>
		 * mengka = mengka test（存储在jvm内存中的）<br>
		 */
		System.out.println("id = " + bbMengka.getId());
		System.out.println("baicai = " + bbMengka.getBaicai());
		System.out.println("qingcai = " + bbMengka.getQingcai());
		System.out.println("mengka = " + bbMengka.getMengka());

		String logString = ToStringBuilder.reflectionToString(bbMengka);
		System.out.println("mengka = " + logString);
	}

}

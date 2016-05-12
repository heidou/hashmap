package mengka.transient_02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.lang.builder.ToStringBuilder;
import mengka.transient_01.Mengka;

/**
 *  transientʹ��
 *  <hr>
 *  <ul>
 *  <li>transient����û�в������л���û�б����䣻</li>
 *  <li>static���������ڴ��еģ�����Ҳ����������л���</li>
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
		mengka.setQingcai("qingcaiAAA");// transient����
		mengka.setMengka("mengka test");

		/**
		 * ��mengka����д���ļ���
		 * 
		 */
		String path = "/Users/hyy044101331/work_hyy/hashMap/src/main/java/mengka/transient_02/data.txt";
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(
				path));
		os.writeObject(mengka); // ��mengka����д���ļ�
		os.flush();
		os.close();

		/**
		 * ���ļ��ж�ȡmengka����
		 * 
		 */
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
		Mengka bbMengka = (Mengka) is.readObject(); // �����ж�ȡUser������
		is.close();

		/**
		 * id = 9470681<br>
		 * baicai = baicaiAAA<br>
		 * qingcai = null��transient����û�в������л���<br>
		 * mengka = mengka test���洢��jvm�ڴ��еģ�<br>
		 */
		System.out.println("id = " + bbMengka.getId());
		System.out.println("baicai = " + bbMengka.getBaicai());
		System.out.println("qingcai = " + bbMengka.getQingcai());
		System.out.println("mengka = " + bbMengka.getMengka());

		String logString = ToStringBuilder.reflectionToString(bbMengka);
		System.out.println("mengka = " + logString);
	}

}

package mengka.serializable_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * ʵ�ֵ���Externalizable�ӿڣ���û���κζ��������Զ����л�����Ҫ��writeExternal�����н����ֹ�ָ����Ҫ���л��ı�����
 * �����Ƿ�transient�����޹ء�
 * 
 * @author mengka.hyy
 * 
 */
public class Taa {

	public static void main(String[] args) throws Exception {

		String path = "src//main//java//mengka//serializable_03//externalizable_data";

		Mengka mengka = new Mengka();
		mengka.setQingcai("�����AAA..");
		mengka.setXigua("������AAA..");
		mengka.setBaicai("��ײ�aaa����");

		/**
		 * ���л�
		 */
		FileOutputStream outputStream = new FileOutputStream(new File(path));
		ObjectOutput out = new ObjectOutputStream(outputStream);
		out.writeObject(mengka);

		/**
		 * �����л�
		 */
		FileInputStream inputStream = new FileInputStream(new File(path));
		ObjectInput in = new ObjectInputStream(inputStream);
		Mengka bbMengka = (Mengka) in.readObject();
		System.out.println(bbMengka.baicai);
		System.out.println(bbMengka.qingcai);
		System.out.println(bbMengka.xigua);

		out.close();
		in.close();
	}

}

package mengka.serializable_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 实现的是Externalizable接口，则没有任何东西可以自动序列化，需要在writeExternal方法中进行手工指定所要序列化的变量，
 * 这与是否被transient修饰无关。
 * 
 * @author mengka.hyy
 * 
 */
public class Taa {

	public static void main(String[] args) throws Exception {

		String path = "src//main//java//mengka//serializable_03//externalizable_data";

		Mengka mengka = new Mengka();
		mengka.setQingcai("大青菜AAA..");
		mengka.setXigua("大西瓜AAA..");
		mengka.setBaicai("大白菜aaa。。");

		/**
		 * 序列化
		 */
		FileOutputStream outputStream = new FileOutputStream(new File(path));
		ObjectOutput out = new ObjectOutputStream(outputStream);
		out.writeObject(mengka);

		/**
		 * 反序列化
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

package mengka.serializable_02;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import mengka.serializable_02.flatbuffers.FlatBufferBuilder;
import mengka.serializable_02.flatbuffers.MyGame.Example.Monster;
import mengka.serializable_02.flatbuffers.MyGame.Example.Vec3;

/**
 * ���л�������<br>
 *       Google������һ�����л���FlatBuffers���ص��ǿ���ֱ�Ӷ����ö���ķ����л�<br>
 *       <a href="https://github.com/google/flatbuffers">https://github.com/google/flatbuffers</a>
 *  <ul> 
 *    <li>��ƽ̨���ṩ��C++/Java�ӿڣ�</li>
 *    <li>������FlatBuffers�������ƶ��豸������Ҫ����ߵ����ܣ����͵���Դ�����ڴ桢����CPU�ȣ���</li>
 *    <li><font color="red" size="+1">����Ҫ��</font>����Ҫ���/��������Ľṹ�����ݶ��Զ�������ʽ���棬����Ҫ���ݽ������̣�����Ҳ���Է��㴫�ݣ�</li> 
 *    <li>ǿ����ϵͳ���ڱ���׶ξ���Ԥ��һЩbug�Ĳ�����</li>
 *  </ul>
 *  <hr>
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	/**
	 *  FlatBuffers���������ڿ�����С������Ҫ��������û�н�������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String path = "src//main//java//mengka//serializable_02//monsterdata_test.bin";
		byte[] data = null;
		File file = new File(path);
		RandomAccessFile f = null;
		try {
			f = new RandomAccessFile(file, "r");
			data = new byte[(int) f.length()];
			f.readFully(data);
			f.close();
		} catch (java.io.IOException e) {
			System.out.println("FlatBuffers test: couldn't read file");
			return;
		}
		
		// ��byte�����ȡMonster�ṹ������
		ByteBuffer bb = ByteBuffer.wrap(data);
		Monster monster = Monster.getRootAsMonster(bb,0);
		
		short hp = monster.hp();
		Vec3 pos = monster.pos();

		// ��������Monster�ṹ������
		FlatBufferBuilder fbb = new FlatBufferBuilder(1);
		 
		// �����ַ�������
		int str = fbb.createString("MyMonster");
		 
		// ����table�ṹ������
		Monster.startMonster(fbb);
		Monster.addPos(fbb, Vec3.createVec3(fbb, 1.0f, 2.0f, 3.0f, 3.0, (byte)4, (short)5, (byte)6));
		Monster.addHp(fbb, (short)80);
		Monster.addName(fbb, str);
//		Monster.addInventory(fbb, inv);
//		Monster.addTest_type(fbb, (byte)1);
//		Monster.addTest(fbb, mon2);
//		Monster.addTest4(fbb, test4s);
		int mon = Monster.endMonster(fbb);
		 
		// ���Ӹ�Vector�ṹ������
		Monster.startInventoryVector(fbb, 5);
		for (byte i = 4; i >=0; i--) fbb.addByte(i);
		int inv = fbb.endVector();
	}

}

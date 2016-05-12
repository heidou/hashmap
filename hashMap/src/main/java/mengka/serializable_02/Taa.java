package mengka.serializable_02;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import mengka.serializable_02.flatbuffers.FlatBufferBuilder;
import mengka.serializable_02.flatbuffers.MyGame.Example.Monster;
import mengka.serializable_02.flatbuffers.MyGame.Example.Vec3;

/**
 * 序列化法二：<br>
 *       Google发布了一个序列化库FlatBuffers，特点是可以直接读不用额外的反序列化<br>
 *       <a href="https://github.com/google/flatbuffers">https://github.com/google/flatbuffers</a>
 *  <ul> 
 *    <li>跨平台，提供了C++/Java接口；</li>
 *    <li>尤其是FlatBuffers更适用移动设备，他们要求更高的新能，更低的资源需求（内存、带宽、CPU等）；</li>
 *    <li><font color="red" size="+1">［重要］</font>不需要打包/解包。它的结构化数据都以二进制形式保存，不需要数据解析过程，数据也可以方便传递；</li> 
 *    <li>强类型系统，在编译阶段就能预防一些bug的产生；</li>
 *  </ul>
 *  <hr>
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	/**
	 *  FlatBuffers的优势在于开销更小，这主要是由于它没有解析过程
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
		
		// 从byte数组读取Monster结构的数据
		ByteBuffer bb = ByteBuffer.wrap(data);
		Monster monster = Monster.getRootAsMonster(bb,0);
		
		short hp = monster.hp();
		Vec3 pos = monster.pos();

		// 这样创建Monster结构的数据
		FlatBufferBuilder fbb = new FlatBufferBuilder(1);
		 
		// 创建字符串数据
		int str = fbb.createString("MyMonster");
		 
		// 创建table结构的数据
		Monster.startMonster(fbb);
		Monster.addPos(fbb, Vec3.createVec3(fbb, 1.0f, 2.0f, 3.0f, 3.0, (byte)4, (short)5, (byte)6));
		Monster.addHp(fbb, (short)80);
		Monster.addName(fbb, str);
//		Monster.addInventory(fbb, inv);
//		Monster.addTest_type(fbb, (byte)1);
//		Monster.addTest(fbb, mon2);
//		Monster.addTest4(fbb, test4s);
		int mon = Monster.endMonster(fbb);
		 
		// 增加各Vector结构的数据
		Monster.startInventoryVector(fbb, 5);
		for (byte i = 4; i >=0; i--) fbb.addByte(i);
		int inv = fbb.endVector();
	}

}

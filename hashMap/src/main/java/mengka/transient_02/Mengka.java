package mengka.transient_02;

import java.io.Serializable;

/**
 * transient使用
 * <ul>
 * <li>transient修饰的变量，不再是对象持久化的一部分，该变量内容在序列化后无法获得访问；</li>
 * <li>transient只能修改变量，不能修饰方法和类（注意，本地变量是不能被transient关键字修饰的）；</li>
 * <li>被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化；</li>
 * </ul>
 * 第三点可能有些人很迷惑，因为发现在User类中的username字段前加上static关键字后，程序运行结果依然不变，
 * 即static类型的username也读出来为
 * “Alexia”了，这不与第三点说的矛盾吗？实际上是这样的：第三点确实没错（一个静态变量不管是否被transient修饰
 * ，均不能被序列化），反序列化后类中static型变量username的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的
 * <hr>
 * 
 * @author mengka.hyy
 * 
 */
public class Mengka implements Serializable {

	private static final long serialVersionUID = -5849746627322723691L;

	public long id;

	public String baicai;

	public transient String qingcai;
	
	public static String mengka;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBaicai() {
		return baicai;
	}

	public void setBaicai(String baicai) {
		this.baicai = baicai;
	}

	public String getQingcai() {
		return qingcai;
	}

	public void setQingcai(String qingcai) {
		this.qingcai = qingcai;
	}

	public static String getMengka() {
		return mengka;
	}

	public static void setMengka(String mengka) {
		Mengka.mengka = mengka;
	}
}

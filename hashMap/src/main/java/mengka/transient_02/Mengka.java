package mengka.transient_02;

import java.io.Serializable;

/**
 * transientʹ��
 * <ul>
 * <li>transient���εı����������Ƕ���־û���һ���֣��ñ������������л����޷���÷��ʣ�</li>
 * <li>transientֻ���޸ı������������η������ࣨע�⣬���ر����ǲ��ܱ�transient�ؼ������εģ���</li>
 * <li>��transient�ؼ������εı��������ܱ����л���һ����̬���������Ƿ�transient���Σ������ܱ����л���</li>
 * </ul>
 * �����������Щ�˺��Ի���Ϊ������User���е�username�ֶ�ǰ����static�ؼ��ֺ󣬳������н����Ȼ���䣬
 * ��static���͵�usernameҲ������Ϊ
 * ��Alexia���ˣ��ⲻ�������˵��ì����ʵ�����������ģ�������ȷʵû��һ����̬���������Ƿ�transient����
 * �������ܱ����л����������л�������static�ͱ���username��ֵΪ��ǰJVM�ж�Ӧstatic������ֵ�����ֵ��JVM�еĲ��Ƿ����л��ó���
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

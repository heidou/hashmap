package mengka.serializable_03;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 
 * ���л�������<br>
 *       Externalizable
 *       <hr>
 *   �����Զ��������л��Ľӿڣ���Ҫ�Լ��ƶ����л��ı���
 * 
 * @author mengka.hyy
 *
 */
public class Mengka implements Externalizable{

	public transient String baicai = "baicai AAA..";//�����Ƿ�transient�����޹�
	public String qingcai;
	public String xigua;
	
	/**
	 *  ��writeExternal�����н����ֹ�ָ����Ҫ���л��ı����������Ƿ�transient�����޹�
	 * 
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(baicai);
		out.writeObject(qingcai);
		out.writeObject(xigua);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		baicai = (String) in.readObject();
		qingcai = (String) in.readObject();
		xigua = (String) in.readObject();
	}

	public String getQingcai() {
		return qingcai;
	}

	public void setQingcai(String qingcai) {
		this.qingcai = qingcai;
	}

	public String getXigua() {
		return xigua;
	}

	public void setXigua(String xigua) {
		this.xigua = xigua;
	}

	public String getBaicai() {
		return baicai;
	}

	public void setBaicai(String baicai) {
		this.baicai = baicai;
	}		

}

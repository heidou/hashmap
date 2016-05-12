package mengka.serializable_03;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 
 * 序列化法三：<br>
 *       Externalizable
 *       <hr>
 *   不是自定进行序列化的接口，需要自己制定序列化的变量
 * 
 * @author mengka.hyy
 *
 */
public class Mengka implements Externalizable{

	public transient String baicai = "baicai AAA..";//这与是否被transient修饰无关
	public String qingcai;
	public String xigua;
	
	/**
	 *  在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关
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

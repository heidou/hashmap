package mengka.copyOnWriteArraySet_01;

import java.io.Serializable;

public class MengkaDO implements Serializable{

	private static final long serialVersionUID = -6423244805988217140L;

	public Long id;
	
	public String name;
	
	public String weibo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}

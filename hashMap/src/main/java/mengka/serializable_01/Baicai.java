package mengka.serializable_01;

import java.io.Serializable;
import java.util.Map;

public class Baicai implements Serializable{

	private static final long serialVersionUID = 521916938978151716L;

	public long id;
	
	public String name;

	public Map<String,String> aaMap;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getAaMap() {
		return aaMap;
	}

	public void setAaMap(Map<String, String> aaMap) {
		this.aaMap = aaMap;
	}

}

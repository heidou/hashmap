package mengka.queue.ConcurrentLinkedQueue_02;

import java.io.Serializable;
import java.util.Date;

public class BackyardDO implements Serializable{

	private static final long serialVersionUID = -3481984690424059973L;

	private Long shopId; // 用shopId做数据库里面的id

	private Long userId;

	private String nick;

	private String slogan; // 店铺宣言

	private Integer status;
	
	private Long subType;
	
	private Integer favor; //后院的喜欢次数

	private Date gmtCreate;

	private Date gmtModified;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getSubType() {
		return subType;
	}

	public void setSubType(Long subType) {
		this.subType = subType;
	}

	public Integer getFavor() {
		return favor;
	}

	public void setFavor(Integer favor) {
		this.favor = favor;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
}

package org.jesus.Diaspora;

import java.sql.Date;

public class Notify {
	private Date date;
	private String user_notify;
	private String type_notify;
	public Notify(Date date,String user_notify,String type_notify){
		this.date=date;
		this.user_notify=user_notify;
		this.type_notify=type_notify;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setUser_notify(String user_notify) {
		this.user_notify = user_notify;
	}
	public String getUser_notify() {
		return user_notify;
	}
	public void setType_notify(String type_notify) {
		this.type_notify = type_notify;
	}
	public String getType_notify() {
		return type_notify;
	}
}

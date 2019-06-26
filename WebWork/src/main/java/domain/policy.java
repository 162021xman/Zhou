package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import static tool.DaoMs.*;

import java.util.Date;

public class policy {
 private String policyid;
 private String ms;
 private String rid;
 private Date startime;
 private int days;
public String getPolicyid() {
	return policyid;
}
public void setPolicyid(String policyid) {
	this.policyid = policyid;
}
public String getMs() {
	return ms;
}
public void setMs(String ms) {
	this.ms = ms;
}
public String getRid() {
	return rid;
}
public void setRid(String rid) {
	this.rid = rid;
}

public Date getStartime() {
	return startime;
}
public void setStartime(Date startime) {
	this.startime = startime;
}
public int getDays() {
	return days;
}
public void setDays(int days) {
	this.days = days;
}
public String toString() {
	try {
		return getClassMs(this);
	} catch (IllegalArgumentException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
		return null;
	}
}
 
}

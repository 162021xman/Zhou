package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import static tool.DaoMs.*;

public class policy {
 private String policyid;
 private String ms;
 private String rid;
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

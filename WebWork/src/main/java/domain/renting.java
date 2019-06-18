package domain;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import static tool.DaoMs.*;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class renting {
  private String ownerid;
  private String rid;
  private float rentmoney;
  public String getOwnerid() {
	return ownerid;
}
public void setOwnerid(String ownerid) {
	this.ownerid = ownerid;
}
public String getRid() {
	return rid;
}
public void setRid(String rid) {
	this.rid = rid;
}
public float getRentmoney() {
	return rentmoney;
}
public void setRentmoney(float rentmoney) {
	this.rentmoney = rentmoney;
}
public Date getRenttime() {
	return renttime;
}
public void setRenttime(Date renttime) {
	this.renttime = renttime;
}
private Date renttime;
public String toString() {
	return getClassMs(this);
}
}

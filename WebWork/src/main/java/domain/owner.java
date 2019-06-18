package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import static tool.DaoMs.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ScopedProxyMode;
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class owner {
private String ownerid;
private String ownername;
private String ownertel;
private String password;
private int NewMs;
private String wuyeid;
public owner() {
	
}
public owner(String ownerid,String ownername,String ownertel,String password,String wuyeid,int NewMs) {
	this.ownerid=ownerid;
	this.ownername=ownername;
	this.ownertel=ownertel;
	this.password=password;
	this.wuyeid=wuyeid;
	this.NewMs=NewMs;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getOwnerid() {
	return ownerid;
}
public void setOwnerid(String ownerid) {
	this.ownerid = ownerid;
}
public String getOwnername() {
	return ownername;
}
public void setOwnername(String ownername) {
	this.ownername = ownername;
}
public String getOwnertel() {
	return ownertel;
}
public void setOwnertel(String ownertel) {
	this.ownertel = ownertel;
}

public int getNewMs() {
	return NewMs;
}
public void setNewMs(int newMs) {
	NewMs = newMs;
}
public String getWuyeid() {
	return wuyeid;
}
public void setWuyeid(String wuyeid) {
	this.wuyeid = wuyeid;
}
public String toString() {
	return getClassMs(this);
	
}

}

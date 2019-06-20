package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import static tool.DaoMs.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ScopedProxyMode;
public class owner {
private String ownerid;
private String ownername;
private String ownertel;
private String password;
private int NewMs;
private String wuyeid;
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
	try {
		return getClassMs(this);
	} catch (IllegalArgumentException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
		return null;
	}
}

}

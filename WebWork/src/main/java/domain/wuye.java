package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import static tool.DaoMs.*;


public class wuye {
 private String id;
 private String ms,password;
 public String toString() {
		try {
			return getClassMs(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
	}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getMs() {
	return ms;
}
public void setMs(String ms) {
	this.ms = ms;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

 
}

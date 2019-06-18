package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import static tool.DaoMs.*;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class wuye {
 private int id;
 private String ms;
 public String toString() {
		return getClassMs(this);
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMs() {
	return ms;
}
public void setMs(String ms) {
	this.ms = ms;
}
 
}

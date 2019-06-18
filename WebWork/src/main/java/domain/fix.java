package domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import static tool.DaoMs.*;
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class fix {
private String fixid,fixms,fixtype,rid;
public String getFixid() {
	return fixid;
}

public void setFixid(String fixid) {
	this.fixid = fixid;
}

public String getFixms() {
	return fixms;
}

public void setFixms(String fixms) {
	this.fixms = fixms;
}

public String getFixtype() {
	return fixtype;
}

public void setFixtype(String fixtype) {
	this.fixtype = fixtype;
}

public String getRid() {
	return rid;
}

public void setRid(String rid) {
	this.rid = rid;
}
public String toString() {
	return getClassMs(this);
}

}

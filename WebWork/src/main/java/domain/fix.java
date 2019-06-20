package domain;


import static tool.DaoMs.*;

import java.util.Date;

public class fix {
private String fixid,fixms,fixtype,rid;
private Date time;
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
public Date getTime() {
	return time;
}

public void setTime(Date time) {
	this.time = time;
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

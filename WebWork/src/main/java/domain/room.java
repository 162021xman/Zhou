package domain;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import static tool.DaoMs.*;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class room {
  private String rid;
  private String rooms;
  private String owner_id;
  private String space;
  public String toString() {
		return getClassMs(this);
	}
  public String getOwner_id() {
	return owner_id;
}
  
public void setOwner_id(String owner_id) {
	this.owner_id = owner_id;
}
public String getRid() {
	return rid;
}
public void setRid(String rid) {
	this.rid = rid;
}
public String getRooms() {
	return rooms;
}
public void setRooms(String rooms) {
	this.rooms = rooms;
}
public String getSpace() {
	return space;
}
public void setSpace(String space) {
	this.space = space;
}
}

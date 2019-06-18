package Services;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import com.fan.entity.OwnerRepo;

import domain.owner;
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class OwnerSub {
 @Autowired
 private OwnerRepo o;
 @Resource
 private List<owner> owners;
 @Autowired
 private owner owner;
 public OwnerSub() {
	 
 }
 public OwnerSub(OwnerRepo o) {
	 this.o=o;
 }
 public void setOwners(String ownerid,String ownername,String ownertel,String wuyeid) {
 		owners=o.getOwnerInParam(ownerid, ownername, ownertel, wuyeid);
 	}
 
 public void setOwners(String ownerid) {
	 owners=o.getOwnerInParam(ownerid, "%","%","%");//通过id
 }

 public void setOwners(String ownerid,String wuyeid) {
	 owners=o.getOwnerInParam("%","%","%", wuyeid);//通过物业管理的业主
 }
 public boolean InsertOwner(String ownerid, String password, String ownername, String ownertel) {
	 try{
		 o.InsertOwner(ownerid, password, ownername, ownertel);
	 return true;
	 }catch(Exception e) {
		 return false;
	 }
	
 }
 public boolean getLogin(String ownerid,String password) {
	 try{
		 owner=o.getLogin(ownerid, password);
	 return true;
	 }catch(Exception e) {
		 e.printStackTrace();
		 return false;
	 }
 }
 public boolean UpdateOwner(String ownerid, String password, String ownername, String ownertel) {
	 try{
		 o.UpdateOwner(ownerid, password, ownername, ownertel);
	 return true;
	 }catch(Exception e) {
		 return false;
	 }
 }
 public boolean DeleteOwner(String ownerid) {
	 try{
		 o.DelOwner(ownerid);
	 return true;
	 }catch(Exception e) {
		 return false;
	 }
 }

public OwnerRepo getO() {
	return o;
}

public void setO(OwnerRepo o) {
	this.o = o;
}
public owner getOwner() {
	return owner;
}
public List<owner> getOwners() {
	return owners;
}
}

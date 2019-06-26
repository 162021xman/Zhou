package Services;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import com.fan.entity.OwnerRepo;
import com.fan.entity.PolicyRepo;
import com.fan.entity.RoomRepo;

import domain.owner;
import domain.policy;
import domain.room;
@Service
//@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class OwnerSub {
 @Autowired
 private OwnerRepo o;
 @Autowired
 private PolicyRepo porepo;
 @Autowired
 private RoomRepo repo;
 //@Resource
 //private List<owner> owners;
 //@Autowired(required=false)
 //private owner owner;
 public boolean setOwners(String ownerid,String ownername,String ownertel,String wuyeid) {
	 try{
		 o.getOwnerInParam(ownerid, ownername, ownertel, wuyeid);
	 return true;
	 }catch(Exception e) {
		 return false;
	 }
 		
 	}
 
 public boolean setOwners(String ownerid) {
	 try{
		 o.getOwnerInParam(ownerid, "%","%","%");
	 return true;
	 }catch(Exception e) {
		 return false;
	 }
 }

 public boolean setOwners(String ownerid,String wuyeid) {
	 try{
		 o.getOwnerInParam("%","%","%", wuyeid);
	 return true;
	 }catch(Exception e) {
		 return false;
	 }
	//通过物业管理的业主
 }
 public boolean InsertOwner(String ownerid, String password, String ownername, String ownertel,String wuyeid) {
	 try{
		if( o.InsertOwner(ownerid, password, ownername, ownertel,wuyeid)>0)
	 return true;
		return false;
	 }catch(Exception e) {
		 return false;
	 }
	
 }
 public owner getLogin(String ownerid,String password) {
	 try{
		  return o.getLogin(ownerid, password);
	 
	 }catch(Exception e) {
		 e.printStackTrace();
		 return null;
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
		 if(o.DelOwner(ownerid)>0)
	 return true;
	return false;
	 }catch(Exception e) {
		 return false;
	 }
 }
 public List<owner> getOwnerInparam(String ownerid,String ownername,String ownertel,String wuyeid){
	 return o.getOwnerInParam(ownerid, ownername, ownertel, wuyeid);
 }
 public List<policy> getAllpos(){
	return porepo.getAllpolicy();
 }
 public List<room> getBypo(String policyid){
	 return repo.getRoomBypo(policyid);
 }
}

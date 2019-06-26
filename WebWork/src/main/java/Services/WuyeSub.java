package Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.entity.PolicyRepo;
import com.fan.entity.RoomRepo;
import com.fan.entity.wuyeRepo;

import domain.room;
import domain.wuye;
@Service
public class WuyeSub {
	@Autowired
  private wuyeRepo wuye;
	@Autowired
	  private PolicyRepo porepo;
	 @Autowired
	  private RoomRepo rrepo;
  public wuye getLogin(String id,String password) {
	 return wuye.getLoginwuye(id, password);
  }
  public boolean Insertwuye(String id,String ms,String password) {
	  if(wuye.Inserttwuye(id, ms, password)>0)
		  return true;
	  return false;
  }
  public boolean Updatewuye(String id,String password) {
	  if(wuye.Updatetwuye(id, password)>0)
		  return true;
	  return false;
  }
  public List<wuye> getAllwuye(){
	 return wuye.getAllwuye();
  }
  public boolean InsertPolicy(String wuyeid,String id,String rid,Date startime,String ms,int days) {
	if(porepo.InsertPolicy(id, rid, startime, ms, days)>0)
	  if(rrepo.UpdateRoomwuye(id, wuyeid)>0)
		  return true;
	return false;
	
  }
  public int getMaxPkInPo() {
	  return Integer.parseInt(porepo.getMaxPk());
  }
}

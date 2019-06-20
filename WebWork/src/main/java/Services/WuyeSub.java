package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.entity.wuyeRepo;
import domain.wuye;
@Service
public class WuyeSub {
	@Autowired
  private wuyeRepo wuye;
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
}

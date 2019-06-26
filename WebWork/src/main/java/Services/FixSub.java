package Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.entity.FixRepo;
import domain.fix;
@Service
public class FixSub {
 @Autowired
  private FixRepo fix;
 public boolean InsertFix(String fixid,String fixms,String fixtype,String rid,Date time) {
	 try {
	 if(fix.InsertFix(fixid, fixms,fixtype,rid,time)>0)
		 return true;
	 }catch(Exception e) {
		 e.printStackTrace();
		 return false;
	 }
	return false;
	
 }
 public boolean DeleteFixInRid(String rid) {
	 if(fix.DelFixInRid(rid)>0)
		 return true;
	 return false;
	 
 }
 public String getMaxPk() {
	 return fix.getMaxPk();
 }
 public List<fix> getAllFix() {
	 return fix.getAllfix();
 }
}

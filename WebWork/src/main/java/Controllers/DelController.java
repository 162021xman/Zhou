package Controllers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fan.entity.OwnerRepo;
import com.fan.entity.RentingRepo;
import com.fan.entity.RoomRepo;

@Controller
@MapperScan("com.fan.entity")
@RequestMapping("del")
public class DelController {
	@Autowired
	private OwnerRepo ownerrepo;
	private RentingRepo rentingrepo;
	private RoomRepo roomrepo;
	@RequestMapping(value="owner",method=RequestMethod.POST)
	  public String addowner(@RequestParam("ownerid")String ownerid)
			  {
		System.out.println(ownerid);
		  if(ownerrepo.DelOwner(ownerid)>0)
			  return "welcome";
		  return "home";
	  }
	
}

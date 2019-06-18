package Controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import com.fan.entity.OwnerRepo;
import com.fan.entity.RentingRepo;
import com.fan.entity.RoomRepo;
import Services.OwnerSub;
import domain.renting;
@Controller
@RequestMapping("/owner")
@SessionAttributes("owner")
public class OwnerController {
	@Autowired
	private OwnerSub owner;
	@Autowired
	private RentingRepo r;
	private renting renting;
	private RoomRepo roomrepo;
	@RequestMapping(value="add",method=RequestMethod.POST)
	  public String addowner(@RequestParam("ownerid")String ownerid,
			  @RequestParam("password")String password,
			  @RequestParam("ownername")String ownername,@RequestParam("ownertel")String ownertel,
			  Model model) {
		System.out.println("addContrller"+ownername);
		model.addAttribute("error","添加成功");
		if(!owner.InsertOwner(ownerid, password, ownername, ownertel)) 
		  model.addAttribute("error","添加失败");
		return "insert";
	  }
	@PostMapping("update")
	public String UpdateOwner(String ownerid,String password,String ownername,String ownertel,Model model) {
		model.addAttribute("error","修改成功");
		if(owner.UpdateOwner(ownerid, password, ownername, ownertel))
			model.addAttribute("error","修改失败");
			return "update";
	}
	@PostMapping("/login")
	public String SelectOwner(String ownerid,String password,Model model)  {
		model.addAttribute("error","登录失败");
		//System.out.println(owner.hashCode());
		if(owner.getLogin(ownerid, password)) {
			//System.out.println(owner.hashCode());
		//map.addAttribute("owner",this.owner);
			model.addAttribute("error", "成功登录");
			int a=owner.getOwner().getNewMs();//访问未读物业通知
			if(a>0) {
			//System.out.println("owner");
			model.addAttribute("owner",a);
			}
			return "home";//进入登录成功界面
		}
		return "login";
	}
	@RequestMapping("renting")
	public renting SelectRenting() {//返回ajax数据
		return this.renting;
	}
	public void setRentingrepo(RentingRepo r) {
		renting=r.getRenting("%",owner.getOwner().getOwnerid());
	}
}

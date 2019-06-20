package Controllers;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.acl.Owner;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import com.fan.entity.OwnerRepo;
import com.fan.entity.RentingRepo;
import com.fan.entity.RoomRepo;

import Services.FixSub;
import Services.OwnerSub;
import Services.roomSub;
import domain.owner;
import domain.renting;
import domain.room;
@Controller
@SessionAttributes(names= {"owner","owners"})
public class OwnerController {
	@Autowired
	private OwnerSub ownersub;
	@Autowired
	private FixSub fixsub;
	@Autowired
	private roomSub roomsub;
	@RequestMapping(value="add",method=RequestMethod.POST)
	  public String addowner(@RequestParam("ownerid")String ownerid,
			  @RequestParam("password")String password,
			  @RequestParam("ownername")String ownername,@RequestParam("ownertel")String ownertel,
			  Model model) {
		System.out.println("addContrller"+ownername);
		model.addAttribute("error","添加成功");
		if(ownersub.InsertOwner(ownerid, password, ownername, ownertel,"10086"))//默认物业管理员是10086号
		  model.addAttribute("error","添加失败");
		return "insert";
	  }
	@PostMapping("update")
	public String UpdateOwner(String ownerid,String password,String ownername,String ownertel,Model model) {
		model.addAttribute("error","修改成功");
		if(ownersub.UpdateOwner(ownerid, password, ownername, ownertel))
			model.addAttribute("error","修改失败");
			return "update";
	}
	@PostMapping("loginM")
	public String SelectOwner(@RequestParam("ownerid")String ownerid,
			@RequestParam("password")String password,Model model,ModelMap modelmap)  {
		model.addAttribute("error","登录失败");
		owner thiso=ownersub.getLogin(ownerid, password);
		System.out.println(thiso.hashCode());
		if(thiso!=null) {
			model.addAttribute("error", "成功登录");
			//modelmap.addAttribute("owner",thiso);
			model.addAttribute("owner",thiso);
			int a=thiso.getNewMs();//访问未读物业通知
			if(a>0) {
			model.addAttribute("ownerNewMs",thiso.getNewMs());
			}
			return "home";//进入登录成功界面
		}
		return "redirect:login.html";
	}
	@PostMapping("UpdatePsM")
	public String UpdatePsParam(String newps,@ModelAttribute("owner")owner thiso) {
		if(ownersub.UpdateOwner(thiso.getOwnerid(),newps,thiso.getOwnername()
				,thiso.getOwnertel() ))
		return "修改成功";
		return "修改失败";
	}
	@GetMapping("fix")
	public String setRentingrepo(@ModelAttribute("owner")owner thiso,Model model) {
		model.addAttribute("listroom",roomsub.getRoomOwnerid(thiso.getOwnerid()));
		//List<String> attrs=new ArrayList<String>();
		return "fix";
	}
	@PostMapping("fixM")
	@ResponseBody
	public String fixM(String rid,String fixms,String fixtype,@ModelAttribute("owner")owner thiso) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date time=new Date(System.currentTimeMillis());
		String stime=df.format(time);
		time=df.parse(stime);
		int id=Integer.valueOf(fixsub.getMaxPk())+1;
		if(fixsub.InsertFix(String.valueOf(id),fixms, fixtype, rid,time))
			return "报修成功";
		return "报修失败";
	}
	@GetMapping("UpdatePs")
    public String UpdatePs(@ModelAttribute("owner")owner thiso,Model model) {
		System.out.println(thiso.toString());
		model.addAttribute("owner",thiso);
		return "UpdatePs";
	}
	@GetMapping("InsertOwner") 
	public String InsertOwner(@ModelAttribute("owner")owner thiso,Model model) {
		String attrs[]=thiso.toString().split("\n");
	    attrs=attrs[1].split("/");
		model.addAttribute("attrs",attrs);
		return "add";
	}
	
}

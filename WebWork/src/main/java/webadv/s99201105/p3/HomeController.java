package webadv.s99201105.p3;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import domain.*;
import com.fan.entity.OwnerRepo;
import com.fan.entity.OwnerService;
import com.fan.entity.RentingRepo;
import com.fan.entity.RoomRepo;

import Services.OwnerSub;

@Controller("home")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HomeController {
	private List<owner> owners;
	//@Autowired
	private RentingRepo rentingrepo;
	private RoomRepo roomrepo;
	//private List<String> tasks=Arrays.asList("t1","t2");
    
	//@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.INTERFACES)
	@Autowired
	public void setOwner(OwnerRepo o) {
		owners=o.getAllOwner();
	}
	@RequestMapping("/")
  public String  index(Model model) {
		//System.out.println(ownerrepo.getAllOwner());
		//System.out.println(ownerrepo.getOwner("162021").getOwnername().hashCode());
		//System.out.println(ownerrepo.getOwner("162021").getOwnername().toString());
		//System.out.println(this.toString());
		System.out.println(owners.get(0).hashCode());
	  return "welcome";
  }
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/res")
	public String res() {
		return "res";
	}
	@RequestMapping("welcome")
    public String welcome() {
		return "welocme";
	}
	
	@RequestMapping("/home")
	  public String  home(Model model) {
		  return "home";
	  }
	
}

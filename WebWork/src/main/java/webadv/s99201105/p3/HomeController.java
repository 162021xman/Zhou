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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import domain.*;
import com.fan.entity.OwnerRepo;
import com.fan.entity.RentingRepo;
import com.fan.entity.RoomRepo;

import Services.OwnerSub;

@Controller("home")
public class HomeController {
 @RequestMapping("/")
  public String  index() {
		//System.out.println(ownerrepo.getAllOwner());
		//System.out.println(ownerrepo.getOwner("162021").getOwnername().hashCode());
		//System.out.println(ownerrepo.getOwner("162021").getOwnername().toString());
		//System.out.println(this.toString());
   return "redirect:login.html";
	 
  }
}

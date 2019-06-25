package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import Services.OwnerSub;
import Services.WuyeSub;
import domain.login;
import domain.owner;
import domain.wuye;
//管理业主信息

@Controller
@SessionAttributes(names= {"wuye","wuyes"})
public class WuyeController {
  @Autowired
  private WuyeSub wuyesub;
  @Autowired
  private OwnerSub ownersub;
  @GetMapping("policy")
  public String getPolicy(Model model) {
	 
	  return "";
  }
  @PostMapping("login2M")
  public String getLoginWuye(String id,String password,ModelMap modelmap,Model model) {
	  //System.out.println(map.getId()+map.getPassword());
	 wuye wuye= wuyesub.getLogin(id,password);
	//System.out.println(wuye.getId());
	 //String[] attrs=wuye.toString().split("/n")[1].split("/");
	 if(wuye!=null) {
		 
	 modelmap.addAttribute("wuye",wuye);
	  //model.addAttribute("Wuye",wuye);
	  //model.addAttribute("attrs",attrs);
	  return "redirect:home2";
	 }
     model.addAttribute("error","用户名或密码错误");
	  return "error";
  }
  @GetMapping("SelectAllowners")
  public String getOwners(Model model,@ModelAttribute("wuye")wuye thiso) {
	List<owner> owners=ownersub.getOwnerInparam("%","%","%",thiso.getId());
	//System.out.println(owners.get(0).getOwnerid());
	model.addAttribute("owners",owners);
	List<String> attrs=new ArrayList<String>();
	attrs.add("用户账号(编号)");
	attrs.add("用户名");
	attrs.add("电话");
	model.addAttribute("title", "业主信息");
	model.addAttribute("attrs",attrs);
	 return "home2";
  }
  @GetMapping("SelectAllownersM")
  @ResponseBody
  public List<owner> getOwner(String ownerid,@ModelAttribute("wuye")wuye thiso,Model model) {
	  List<owner> owners=ownersub.getOwnerInparam(ownerid, "%","%",thiso.getId());
	  model.addAttribute("owners", owners);
	return owners;
  }
  @GetMapping("Updateowner")
  public String Updateowner(Model model) {
	  String[] attrs= {"ownerid","ownername","ownertel","password"};
	  model.addAttribute("attrs",attrs);
	  return "Update";
  }
  @GetMapping("Insertowner")
  public String Insertowner(Model model) {
	  String[] attrs= {"ownerid","ownername","ownertel","password"};
	  model.addAttribute("attrs",attrs);
	  return "add";
  }
  public String getInsert(@ModelAttribute("wuye")wuye thiso) {
	  return "add";
  }
  @PostMapping("UpdateownerM")
  @ResponseBody
  public String UpdateOwner(@ModelAttribute("wuye")wuye thiso,
		  String ownerid,String ownername,String ownertel,String password) {
	  if(thiso!=null)
	   if(ownersub.UpdateOwner(ownerid, password, ownername, ownertel))
	     return "修改成功";
	  
	  return "修改失败";
  }
  @PostMapping("InsertownerM")
  @ResponseBody
  public String InsertOwner(@ModelAttribute("wuye")wuye thiso,
		  String ownerid,String ownername,String ownertel,String password) {
	  if(ownersub.InsertOwner(ownerid, password, ownername, ownertel,thiso.getId()))
	  return "添加成功";
	  return "添加失败";
  }
  @PostMapping("DeleteownerM")
  @ResponseBody
  public String DeleteOwner(String ownerid) {
	  System.out.println(ownerid);
	  if(ownersub.DeleteOwner(ownerid))
		  return "删除成功";
	  return "删除失败";
  }
}

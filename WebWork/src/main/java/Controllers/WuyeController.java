package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import Services.OwnerSub;
import Services.WuyeSub;
import domain.owner;
import domain.wuye;
//管理业主信息
@Service
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
  @PostMapping("loginwuye")
  public String getLoginWuye(String id,String password,Model model) {
	 wuye wuye= wuyesub.getLogin(id, password);
	  model.addAttribute("wuye",wuye);
	  return "home2";
  }
  @GetMapping("SelectAllowners")
  @ResponseBody
  public String getOwners(Model model,@ModelAttribute("wuye")wuye thiso) {
	 model.addAttribute("listowner",ownersub.getOwnerInparam("%","%","%",thiso.getId()));
	 return "home2";
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
	  if(ownersub.DeleteOwner(ownerid))
		  return "删除成功";
	  return "删除失败";
  }
}

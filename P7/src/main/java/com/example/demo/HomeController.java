package com.example.demo;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.Bean.Teacher;
import com.example.demo.Bean.Yuyue;
import com.example.demo.Bean.inform;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.repository.YuyueRepository;
import com.example.demo.repository.informmatinRepository;

@Controller
public class HomeController {	
	@Autowired//利用这个注解
	private TeacherRepository t;//创建一个对象
	@Autowired
	private informmatinRepository m;
	@Autowired
	private YuyueRepository n;
	@PostMapping("/login2")
	public String login2( Model model,
			String account ,String password) {
		if ("abc".equals(account) && "123".equals(password)) {
			List<inform> list=m.findAll();
			model.addAttribute("zcontent",list);			
			return "home";
		}
			
			
	else
		return "index";
	}
	
	@GetMapping("/turn1")
	public String turn(Model model) {
		List<inform> list=m.findAll();
		model.addAttribute("zcontent",list);
		return "home";
	}
	
	@GetMapping("/level2")
	public String level(Model model) {
		return "level2";
	}
	
	@GetMapping("/home2")
	public String home(Model model) {
		List<Teacher> list=t.findAll();
		model.addAttribute("teacher_list",list);
		return "tables";
	}
	
	@GetMapping("/edit")
	public String edit(Integer id, Model model) {
		Teacher teacher = t.findAll().stream()
		.filter(i->i.getId()==id)
		.findFirst().orElseGet(Teacher::new);
		model.addAttribute("teacher", teacher);
		return "edit";
	}
	
	@PostMapping("/save")
	public String save(Teacher teacher) {
		t.update(teacher);
		return "redirect:home2";
	}
	
	
	@GetMapping("/yupeople")
	public String information(Model model) {
		List<Yuyue> list=n.getAllYuyue();
		model.addAttribute("people_list", list);
		return "people";
	}

}
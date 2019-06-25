package com.example.demo;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Bean.Teacher;
import com.example.demo.repository.TeacherRepository;

@Controller
public class HomeController {	
	@Autowired//利用这个注解
	private TeacherRepository t;//创建一个对象
	@PostMapping("/login2")
	public String login2( Model model,
			String account ,String password) {
		if ("abc".equals(account) && "123".equals(password)) {
			List<Teacher> list=t.findAll();
			model.addAttribute("teacher_list",list);
			return "home";
		}
			
			
	else
		return "index";
	}
	@GetMapping("/home")
	public String home(Model model) {
		List<Teacher> list=t.findAll();
		model.addAttribute("teacher_list",list);
		return "home";
	}

}
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repository.YuyueRepository;

@Controller
public class AddController {
@Autowired
private YuyueRepository yuyue;

	@PostMapping("addyuyue")
	@ResponseBody
	public String Insertyuyue(String kname,String kphone) {
		if(yuyue.InsertYuyue(kname, kphone)>0)
			return "预约成功";
		return "预约失败";
	}
	
}

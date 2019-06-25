package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Bean.inform;
import com.example.demo.Bean.vo.R;
import com.example.demo.Bean.vo.T;
import com.example.demo.repository.YuyueRepository;
import com.example.demo.repository.informmatinRepository;

@Controller
public class DelController {
	@Autowired
	public informmatinRepository n;
    @Autowired
    public YuyueRepository a;
	@ResponseBody
	@GetMapping("/del/{id}")
	public R delinform(@PathVariable String id) {
		n.Delinform(id);
		return R.ok();
	}
	
	

}

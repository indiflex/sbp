package com.jade.sbp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jade.sbp.mapper.UserMapper;

@Controller
public class UserController {
	
	@Autowired
	private UserMapper mapper;
	
	@RequestMapping("/hello2")
	public void hello2(Model model) throws Exception {
		String uid = "user1";
		model.addAttribute("uname", mapper.getUname(uid));
	}
}

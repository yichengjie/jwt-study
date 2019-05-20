package com.yicj.jwt.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageUIController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String defautPage() {
		return "index";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/msg")
	public String msg() {
		return "msg";
	}
}

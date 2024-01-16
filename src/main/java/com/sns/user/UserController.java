package com.sns.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
@RequestMapping("/user")
@Controller
public class UserController {
	@GetMapping("/sign-up-view")
	public String signUpView(Model model) {
		model.addAttribute("viewName","user/signup");
		return "template/layout";
	}
	
	@GetMapping("/sign-in-view")
	public String signInView(Model model) {
		model.addAttribute("viewName","user/signin");
		return "template/layout";
	}
	@RequestMapping("/sign-out")
	public String signOut(HttpSession session) {
		// 세션에 있는 내용을 비운다.
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		// redirect 로그인 화면으로 이동 sign-in -view
		return "redirect:/user/sign-in-view";
	}
}

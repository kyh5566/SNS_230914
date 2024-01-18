package com.sns.timeline;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sns.timeline.bo.PostBO;

import jakarta.servlet.http.HttpSession;

public class TimelineRestController {
	@Autowired
	private PostBO postBO;
	
//	@PostMapping("/create")
//	public Map<String, Object> create(
//			@RequestParam("content") String content
//			,HttpSession session) {
//		
//		int userId = (int)session.getAttribute("userId");
		//String userLoginId = (String)session.getAttribute("userLoginId");
		
//		postBO.addPost(content,userId);
//		return "";
	
}

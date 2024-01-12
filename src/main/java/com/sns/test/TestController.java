package com.sns.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sns.comment.mapper.CommentMapper;

@Controller
public class TestController {
	@Autowired
	private CommentMapper commentMapper;
	
	@GetMapping("/test1")
	@ResponseBody
	public String test1() {
		return "hello world!";
	}
	@GetMapping("/test2")
	@ResponseBody
	public Map<String, Object> test2 () {
		Map<String, Object> result = new HashMap<>();
		result.put("1", 1);
		result.put("2", 2);
		result.put("3", 3);
		return result;
	}
	@GetMapping("/test3")
	public String test3() {
		return "test/test";
	}
	@GetMapping("/test4")
	@ResponseBody
	public List<Map<String, Object>> test4() {
		return commentMapper.selectCommentList();
	}
	@GetMapping("/signup")
	public String signup() {
		return "sns/signup";
	}
	@GetMapping("/signin")
	public String signin() {
		return "sns/signin";
	}
}

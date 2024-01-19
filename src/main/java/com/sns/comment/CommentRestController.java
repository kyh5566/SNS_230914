package com.sns.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sns.comment.bo.CommentBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/comment")
@RestController
public class CommentRestController {
	@Autowired
	private CommentBO commentBO;
	
	@PostMapping("/create")
	public Map<String, Object> CreateComment(
			@RequestParam("content") String content
			,@RequestParam("postId") int postId
			,HttpSession session) {
		
		//db insert
		Integer userId = (Integer)session.getAttribute("userId");
		commentBO.addComment(content, postId, userId);
		
		//응답값
		Map<String,Object> result = new HashMap<>();
		if (userId == null) {
			result.put("code", 500);
			result.put("error_message", "로그인을 해주세요.");
			return result;
		}
		
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}

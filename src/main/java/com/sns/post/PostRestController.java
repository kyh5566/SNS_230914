package com.sns.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sns.post.bo.PostBO;

import jakarta.servlet.http.HttpSession;
@RestController
@RequestMapping("/post")
public class PostRestController {
	@Autowired
	private PostBO postBO;
	
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam(value = "content", required = false) String content
			,@RequestParam("file") MultipartFile file
			,HttpSession session) {
		
	
		int userId = (int)session.getAttribute("userId");
		
		// 폴더명 생성에 필요한 파라미터
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		
		//db insert
		postBO.addPost(content,userId,file,userLoginId);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	@DeleteMapping("/delete")
	public Map<String,Object> delete(
			@RequestParam("postId") int postId
			,HttpSession session) {
		
		postBO.deletePostByPostId(postId);
		
		
		Map<String,Object> result = new HashMap<>();
		
		result.put("code", 200);
		
		return result;
	}
}

package com.sns.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sns.common.EncryptUtils;
import com.sns.user.bo.UserBO;
import com.sns.user.entity.UserEntity;
@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {
		UserEntity user = userBO.getUserEntityByLoginId(loginId);
		
		Map<String, Object> result = new HashMap<>();
		
		if (user != null) {
			result.put("code", 500);
			result.put("is-duplicated-id", true);
		} else {
			result.put("code", 200);
			result.put("is-duplicated-id", false);
		}
		return result;
	}
	
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(
			//파라미터들
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("email") String email) {
		 
		String hashedPassword = EncryptUtils.md5(password);
		
		//db insert
		Integer userId = userBO.addUser(loginId, hashedPassword, name, email);
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		if (userId != null) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "회원가입에 실패했습니다");
		}
		return result;
	}
}

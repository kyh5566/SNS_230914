package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sns.common.FileManagerService;
import com.sns.post.entity.PostEntity;
import com.sns.post.repository.PostRepository;

@Service
public class PostBO {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private FileManagerService fileManagerService;
	
	// input: X   output: List<PostEntity>
	public List<PostEntity> getPostList() {
		return postRepository.findAllByOrderByIdDesc();
	}
	
	// intput : 이미지파일, 내용     output: x
	public PostEntity addPost(String content,int userId,MultipartFile file,String userLoginId) {
		
		String imagePath = null;
		if (file != null) {
			imagePath =  fileManagerService.savaFile(userLoginId,file);
		}
		
		return postRepository.save(PostEntity.builder()
				.userId(userId)
				.content(content)
				.imagePath(imagePath)
				.build());
	}
}

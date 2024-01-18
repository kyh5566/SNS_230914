package com.sns.timeline.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.timeline.entity.PostEntity;
import com.sns.timeline.repository.PostRepository;

@Service
public class PostBO {
	@Autowired
	private PostRepository postRepository;
//	@Autowired
//	private PostMapper postMapper;
	
	// input: X   output: List<PostEntity>
	public List<PostEntity> getPostList() {
		return postRepository.findAllByOrderByIdDesc();
	}
	
	// intput : 이미지파일, 내용     output: x
//	public void addPost(String content) {
//		postMapper.insertPost(content);
//	}
}

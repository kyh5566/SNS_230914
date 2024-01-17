package com.sns.timeline.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.timeline.repository.PostRepository;

@Service
public class PostBO {
	@Autowired
	private PostRepository postRepository;
	
}

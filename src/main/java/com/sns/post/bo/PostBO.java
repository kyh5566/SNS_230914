package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sns.comment.bo.CommentBO;
import com.sns.common.FileManagerService;
import com.sns.like.bo.LikeBO;
import com.sns.post.entity.PostEntity;
import com.sns.post.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PostBO {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
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
	
	public void deletePostByPostId(int postId, int userId) {
		// 기존 글 가져오기
		PostEntity post = postRepository.findById(postId).orElse(null);
		if (post == null) {
			log.info("[글 삭제] post is null postId:{}, userId:{}", postId, userId);
			return;
		}
		// 글 삭제
		postRepository.deleteById(postId);
		
		// 이미지 삭제
		fileManagerService.deleteFile(post.getImagePath());
		
		// 댓글,좋아요 db에서 삭제
		commentBO.deleteCommentById(postId);
		likeBO.deleteLikeById(postId);
	}
}

package com.sns.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sns.comment.domain.Comment;

@Mapper
public interface CommentMapper {
	public List<Comment> selectCommentList();
	
	public void insertComment(
			@Param("content")String content,
			@Param("postId")int postId, 
			@Param("userId")int userId);
	
	public List<Comment> selectCommentListByPostId(int postId);
	
	public void deleteCommentById(int id);
}

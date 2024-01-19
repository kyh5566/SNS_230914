package com.sns.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.comment.domain.Comment;
import com.sns.comment.mapper.CommentMapper;

@Service
public class CommentBO {
	@Autowired
	private CommentMapper commentMapper;
	
	public List<Comment> getCommentList() {
		return commentMapper.selectCommentList();
	}
	
	public void addComment(String content,int postId, int userId) {
		commentMapper.insertComment(content,postId,userId);
	}
}

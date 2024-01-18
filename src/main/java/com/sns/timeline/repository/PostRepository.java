package com.sns.timeline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sns.timeline.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer>{
	public List<PostEntity> findAllByOrderByIdDesc();
}

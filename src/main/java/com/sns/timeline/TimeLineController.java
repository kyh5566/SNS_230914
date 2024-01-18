package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sns.timeline.bo.PostBO;
import com.sns.timeline.entity.PostEntity;
@RequestMapping("/timeline")
@Controller
public class TimeLineController {
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/timeline-view")
	public String timeListView(Model model) {
		
		// 글목록조회
		List<PostEntity> postList = postBO.getPostList();
		
		model.addAttribute("postList", postList);
		
		model.addAttribute("viewName","timeline/timeline");
		return "template/layout";
	}
}

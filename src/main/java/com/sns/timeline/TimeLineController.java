package com.sns.timeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sns.timeline.bo.PostBO;
@RequestMapping("/timeline")
@Controller
public class TimeLineController {
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/timeline-view")
	public String timeListView(Model model) {
		model.addAttribute("viewName","timeline/timeline");
		return "template/layout";
	}
}

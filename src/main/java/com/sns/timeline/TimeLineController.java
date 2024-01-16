package com.sns.timeline;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/timeline")
@Controller
public class TimeLineController {
	
	@GetMapping("/timeline-view")
	public String timeListView(Model model) {
		model.addAttribute("viewName","timeline/timeline");
		return "template/layout";
	}
}

package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sns.timeline.bo.TimelineBO;
import com.sns.timeline.domain.CardView;

import jakarta.servlet.http.HttpSession;
@RequestMapping("/timeline")
@Controller
public class TimeLineController {
	@Autowired
	private TimelineBO timelineBO;
	
	@GetMapping("/timeline-view")
	public String timeListView(Model model,HttpSession session) {
		
		Integer userId = (Integer)session.getAttribute("userId");
		List<CardView> cardViewList = timelineBO.generateCardViewList(userId);
		
		model.addAttribute("cardViewList", cardViewList);
		
		model.addAttribute("viewName","timeline/timeline");
		return "template/layout";
	}
}

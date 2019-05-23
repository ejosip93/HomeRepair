package hr.java.fpz.controller;


import java.util.List;

import hr.java.fpz.dao.UserDao;
import hr.java.fpz.model.Job;
import hr.java.fpz.model.JobForm;
import hr.java.fpz.model.UserDetails;
import hr.java.fpz.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	JobService jobService;
	
	@RequestMapping("/market")
	public String market(Model model){
		model.addAttribute("jobs", jobService.getAllJobs());
		return "market";
	}
	
	@RequestMapping("/market/job")
	public String addJob(Model model){
		model.addAttribute("command", new JobForm());
		return "job";
	}
	
	@RequestMapping(value = "/market/job", method = RequestMethod.POST)
	public String addJobForm(@ModelAttribute JobForm jobForm, Model model){
		jobService.addJob(jobForm, userDao.getAdditionalUserInfo(SecurityContextHolder.getContext().getAuthentication().getName()));
		model.addAttribute("command", new JobForm());
		return "job";
	}
}

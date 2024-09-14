package com.kapil.springrestproject.controller;

import com.kapil.springrestproject.model.JobPost;
import com.kapil.springrestproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

	@Autowired
	private JobService service;

	@RequestMapping({"/","/home"})
	public String home() {
		return "home";
	}

	@RequestMapping("/addjob")
	public String addJob() {
		return "addjob";
	}

	//if we want to return data in particular format, use produces
	//to reproduce our data in xml, we need to import jackson xml dependency
	//by default jackson json dependency is there in spring
	//on client side, Accept - application/xml
	@GetMapping(path="/jobPosts", produces = "application/xml")
//	@ResponseBody - not required if we are using RESTController annotation
	public List<JobPost> viewJobs(Model model) {
		return service.returnAllJobPosts();
	}

	@GetMapping("jobPosts/{jobId}")
	public JobPost viewJob(@PathVariable int jobId) {
		return service.returnJobPost(jobId);
	}

	//on client side, add Content-Type - application/json
	//on server side, add consumes = "application/xml
	@PostMapping(value = "jobPosts", consumes = "application/xml")
	public JobPost addJobPost(@RequestBody JobPost jobPost) {
		service.addJobPost(jobPost);
		return service.returnJobPost(jobPost.getPostId());
	}

	@PutMapping("jobPost")
	public JobPost updateJobPost(@RequestBody JobPost jobPost) {
		service.updateJobPost(jobPost);
		return service.returnJobPost(jobPost.getPostId());
	}

	@DeleteMapping("jobPost/{jobId}")
	public String deleteJobPost(@PathVariable int jobId) {
		service.deleteJobPost(jobId);
		return "deletejobpost";
	}

	


	
	
	
	
	
	
	
	
	
	
}

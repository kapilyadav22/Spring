package com.kapil.springrestproject.service;

import com.kapil.springrestproject.model.JobPost;
import com.kapil.springrestproject.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
	@Autowired
	public JobRepo repo;

	//method to return all JobPosts
	public List<JobPost> returnAllJobPosts() {
		return repo.returnAllJobPosts();
	}
	// ***************************************************************************

	// method to add a jobPost
	public void addJobPost(JobPost jobPost) {
		 repo.addJobPost(jobPost);
	}

	public JobPost returnJobPost(int jobId) {
		return repo.returnJobPost(jobId);
	}

	public void updateJobPost(JobPost jobPost) {
		  repo.updateJobPost(jobPost);
	}
	public void deleteJobPost(int jobId) {
		repo.deleteJobPost(jobId);
	}
}

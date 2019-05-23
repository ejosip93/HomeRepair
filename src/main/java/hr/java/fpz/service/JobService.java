package hr.java.fpz.service;

import hr.java.fpz.model.Job;
import hr.java.fpz.model.JobForm;
import hr.java.fpz.model.UserDetails;

import java.util.List;

public interface JobService {

	List<Job> getAllJobs();

	void addJob(JobForm jobForm, UserDetails userDetails);

}

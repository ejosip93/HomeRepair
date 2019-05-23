package hr.java.fpz.dao;

import hr.java.fpz.model.Job;
import hr.java.fpz.model.JobForm;
import hr.java.fpz.model.UserDetails;

import java.util.List;

public interface JobDao {

	List<Job> getAllJobs();

	void addJob(JobForm jobForm, UserDetails ud);

}

package hr.java.fpz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.java.fpz.dao.JobDao;
import hr.java.fpz.model.Job;
import hr.java.fpz.model.JobForm;
import hr.java.fpz.model.UserDetails;
import hr.java.fpz.service.JobService;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	JobDao jobDao;
	
	@Override
	public List<Job> getAllJobs() {
		return jobDao.getAllJobs();
	}

	@Override
	public void addJob(JobForm jobForm, UserDetails ud) {
		jobDao.addJob(jobForm, ud);
	}

}

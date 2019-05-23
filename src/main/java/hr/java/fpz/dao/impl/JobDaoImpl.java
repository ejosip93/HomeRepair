package hr.java.fpz.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.java.fpz.dao.JobDao;
import hr.java.fpz.model.Job;
import hr.java.fpz.model.JobForm;
import hr.java.fpz.model.UserDetails;

@Repository
public class JobDaoImpl implements JobDao{

	private static final String GET_ALL_JOBS = "SELECT T1.ID AS ID_JOB, T2.ID AS ID_USER, T2.USERNAME, T2.EMAIL, T1.NAME, T1.DESCRIPTION, T1.PRICE, T2.PICTURE FROM JOB T1 JOIN USERS T2 ON T1.ID_USER = T2.ID";
	private static final String ADD_JOB = "INSERT INTO JOB(id_user, name, description, price) VALUES(?, ?, ?, ?)";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Job> getAllJobs() {
		return jdbcTemplate.query(GET_ALL_JOBS, new BeanPropertyRowMapper<>(Job.class));
	}

	@Override
	public void addJob(JobForm jobForm, UserDetails ud) {
		jdbcTemplate.update(ADD_JOB, ud.getId(), jobForm.getName(), jobForm.getDescription(), jobForm.getPrice());
	}

}

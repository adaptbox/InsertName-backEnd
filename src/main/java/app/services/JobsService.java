package app.services;

import app.entities.Job;
import app.entities.User;
import app.exceptions.InvalidEntityException;
import app.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class JobsService implements JobsServiceInterface {

    private UserDAOInterface userDAOInterface;
    private JobDAOInterface jobDAOInterface;

    @Autowired
    public JobsService(
            UserDAOInterface userDAOInterface,
            JobDAOInterface jobDAOInterface) {
        this.userDAOInterface = userDAOInterface;
        this.jobDAOInterface = jobDAOInterface;
    }

    @Override
    public Job createJobForUser(Job job, Long userId) {
        User user = userDAOInterface.findOne(userId);
        if (user == null) {
            throw new InvalidEntityException("User doesn't exist", Collections.emptyList());
        }
        job.setUser(user);
        jobDAOInterface.save(job);
        return job;
    }

    @Override
    public List<Job> getAllJobs() {
        Iterable<Job> iterable = jobDAOInterface.findAll();
        List<Job> jobs = new ArrayList<>();
        iterable.forEach(jobs::add);
        return jobs;
    }

    @Override
    public List<Job> getAllJobsForUser(Long userId) {
        return jobDAOInterface.findByUserId(userId);
    }

    @Override
    public Job getJob(Long id) {
        return jobDAOInterface.findOne(id);
    }

    @Override
    public Job updateJob(Job job) {
        jobDAOInterface.save(job);
        return job;
    }

    @Override
    public void deleteJob(Long id) {
        jobDAOInterface.delete(id);
    }
}

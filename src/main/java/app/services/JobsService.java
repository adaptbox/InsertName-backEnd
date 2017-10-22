package app.services;

import app.entities.Job;
import app.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Job createJob(Job job) {
        jobDAOInterface.save(job);
        return job;
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

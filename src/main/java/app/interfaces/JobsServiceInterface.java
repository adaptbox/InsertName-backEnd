package app.interfaces;

import app.entities.Job;

import java.util.List;

public interface JobsServiceInterface {
    public Job createJobForUser(Job job, Long userId);
    public List<Job> getAllJobs();
    public List<Job> getAllJobsForUser(Long userId);
    public Job getJob(Long id);
    public Job updateJob(Job job);
    public void deleteJob(Long id);
}

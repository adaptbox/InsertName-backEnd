package app.interfaces;

import app.entities.Job;

public interface JobsServiceInterface {
    public Job createJob(Job job);
    public Job getJob(Long id);
    public Job updateJob(Job job);
    public void deleteJob(Long id);
}

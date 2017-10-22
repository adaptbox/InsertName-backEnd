package app.resources;

import app.dto.JobDTO;
import app.entities.Job;
import app.interfaces.JobsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsResource {

    private JobsServiceInterface jobsServiceInterface;

    @Autowired
    public JobsResource(
            JobsServiceInterface jobsServiceInterface) {
        this.jobsServiceInterface = jobsServiceInterface;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Job create(@RequestBody JobDTO jobDTO) {
        Job job = new Job();
        job.setYear(jobDTO.getYear());
        job.setMake(jobDTO.getMake());
        job.setModel(jobDTO.getModel());
        job.setDescription(jobDTO.getDescription());
        return jobsServiceInterface.createJobForUser(job, jobDTO.getUserId());
    }

    @GetMapping
    public List<Job> getAllJobs() { return jobsServiceInterface.getAllJobs(); }

    @GetMapping(value= "/user/{userId}")
    public List<Job> getUserJobs(@PathVariable long userId) { return jobsServiceInterface.getAllJobsForUser(userId); }

    @GetMapping(value = "/{id}")
    public Job read(@PathVariable long id) {
        return jobsServiceInterface.getJob(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Job update(@RequestBody Job job) {
        return jobsServiceInterface.updateJob(job);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        jobsServiceInterface.deleteJob(id);
    }
}

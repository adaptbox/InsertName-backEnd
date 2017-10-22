package app.resources;

import app.entities.Job;
import app.interfaces.JobsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/jobs")
public class JobsResource {

    private JobsServiceInterface jobsServiceInterface;

    @Autowired
    public JobsResource(
            JobsServiceInterface jobsServiceInterface) {
        this.jobsServiceInterface = jobsServiceInterface;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Job create(@RequestBody Job job) {
        return jobsServiceInterface.createJob(job);
    }

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

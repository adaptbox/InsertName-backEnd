package app.resources;

import app.dto.EstimateDTO;
import app.dto.JobDTO;
import app.entities.Estimate;
import app.entities.Job;
import app.interfaces.EstimatesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estimates")
public class EstimatesResource {

    private EstimatesServiceInterface estimatesServiceInterface;

    @Autowired
    public EstimatesResource(
            EstimatesServiceInterface estimatesServiceInterface) {
        this.estimatesServiceInterface = estimatesServiceInterface;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Estimate create(@RequestBody EstimateDTO estimateDTO) {
        Estimate estimate = new Estimate();
        estimate.setPrice(estimateDTO.getPrice());
        estimate.setDetails(estimateDTO.getDetails());
        return estimatesServiceInterface.createEstimateForJobAndUser(estimate, estimateDTO.getJobId(), estimateDTO.getUserId());
    }

    @GetMapping
    public List<Estimate> getAllEstimates() { return estimatesServiceInterface.getAllEstimates(); }

    @GetMapping(value= "/user/{userId}")
    public List<Estimate> getUserEstimates(@PathVariable long userId) { return estimatesServiceInterface.getAllEstimatesForUser(userId); }

    @GetMapping(value= "/job/{jobId}")
    public List<Estimate> getJobEstimates(@PathVariable long jobId) { return estimatesServiceInterface.getAllEstimatesForJob(jobId); }

    @GetMapping(value = "/{id}")
    public Estimate read(@PathVariable long id) {
        return estimatesServiceInterface.getEstimate(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Estimate update(@RequestBody EstimateDTO estimateDTO) {
        Estimate estimate = estimatesServiceInterface.getEstimate(estimateDTO.getId());
        estimate.setPrice(estimateDTO.getPrice());
        estimate.setDetails(estimateDTO.getDetails());
        return estimatesServiceInterface.updateEstimate(estimate);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        estimatesServiceInterface.deleteEstimate(id);
    }
}

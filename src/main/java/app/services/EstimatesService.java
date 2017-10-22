package app.services;

import app.entities.Estimate;
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
public class EstimatesService implements EstimatesServiceInterface {

    private UserDAOInterface userDAOInterface;
    private JobDAOInterface jobDAOInterface;
    private EstimateDAOInterface estimateDAOInterface;

    @Autowired
    public EstimatesService(
            UserDAOInterface userDAOInterface,
            JobDAOInterface jobDAOInterface,
            EstimateDAOInterface estimateDAOInterface) {
        this.userDAOInterface = userDAOInterface;
        this.jobDAOInterface = jobDAOInterface;
        this.estimateDAOInterface = estimateDAOInterface;
    }

    @Override
    public Estimate createEstimateForJobAndUser(Estimate estimate, Long jobId, Long userId) {
        User user = userDAOInterface.findOne(userId);
        if (user == null) {
            throw new InvalidEntityException("User doesn't exist", Collections.emptyList());
        }
        Job job = jobDAOInterface.findOne(jobId);
        if (job == null) {
            throw new InvalidEntityException("Job doesn't exist", Collections.emptyList());
        }
        estimate.setUser(user);
        estimate.setJob(job);
        estimateDAOInterface.save(estimate);
        return estimate;
    }

    @Override
    public List<Estimate> getAllEstimates() {
        Iterable<Estimate> iterable = estimateDAOInterface.findAll();
        List<Estimate> estimates = new ArrayList<>();
        iterable.forEach(estimates::add);
        return estimates;
    }

    @Override
    public List<Estimate> getAllEstimatesForUser(Long userId) {
        return estimateDAOInterface.findByUserId(userId);
    }

    @Override
    public List<Estimate> getAllEstimatesForJob(Long jobId) {
        return estimateDAOInterface.findByJobId(jobId);
    }

    @Override
    public Estimate getEstimate(Long id) {
        return estimateDAOInterface.findOne(id);
    }

    @Override
    public Estimate updateEstimate(Estimate estimate) {
        estimateDAOInterface.save(estimate);
        return estimate;
    }

    @Override
    public void deleteEstimate(Long id) {
        estimateDAOInterface.delete(id);
    }
}

package app.interfaces;

import app.entities.Estimate;

import java.util.List;

public interface EstimatesServiceInterface {
    public Estimate createEstimateForJobAndUser(Estimate estimate, Long jobId, Long userId);
    public List<Estimate> getAllEstimates();
    public List<Estimate> getAllEstimatesForUser(Long userId);
    public List<Estimate> getAllEstimatesForJob(Long jobId);
    public Estimate getEstimate(Long id);
    public Estimate updateEstimate(Estimate estimate);
    public void deleteEstimate(Long id);
}

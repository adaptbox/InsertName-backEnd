package app.interfaces;

import app.entities.Estimate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstimateDAOInterface extends CrudRepository<Estimate, Long> {
    public List<Estimate> findByUserId(Long userId);
    public List<Estimate> findByJobId(Long jobId);
}
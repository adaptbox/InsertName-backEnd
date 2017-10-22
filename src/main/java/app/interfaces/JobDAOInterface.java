package app.interfaces;

import app.entities.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobDAOInterface extends CrudRepository<Job, Long> {
    public List<Job> findByUserId(Long userId);
}
package app.interfaces;

import app.entities.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobDAOInterface extends CrudRepository<Job, Long> {

}
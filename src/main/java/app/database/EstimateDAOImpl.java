package app.database;

import app.entities.Estimate;
import app.interfaces.EstimateDAOInterface;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class EstimateDAOImpl implements EstimateDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Estimate> findByUserId(Long userId) {
        Criteria criteria = sessionFactory.openSession().createCriteria(Estimate.class);
        criteria.add(Restrictions.eq("user_id", userId));
        return criteria.list();
    }

    public List<Estimate> findByJobId(Long jobId) {
        Criteria criteria = sessionFactory.openSession().createCriteria(Estimate.class);
        criteria.add(Restrictions.eq("job_id", jobId));
        return criteria.list();
    }
}

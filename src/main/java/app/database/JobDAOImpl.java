package app.database;

import app.entities.Job;
import app.interfaces.JobDAOInterface;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class JobDAOImpl implements JobDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Job> findByUserId(Long userId) {
        Criteria criteria = sessionFactory.openSession().createCriteria(Job.class);
        criteria.add(Restrictions.eq("user_id", userId));
        return criteria.list();
    }
}

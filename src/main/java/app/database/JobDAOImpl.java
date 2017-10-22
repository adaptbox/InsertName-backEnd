package app.database;

import app.interfaces.JobDAOInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class JobDAOImpl implements JobDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

}

package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class unitl {

    public Session lj(){
        Configuration configure = new Configuration().configure();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        return session;

    }
}


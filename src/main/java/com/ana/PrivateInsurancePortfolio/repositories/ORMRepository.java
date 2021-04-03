package com.ana.PrivateInsurancePortfolio.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ORMRepository {

    @Autowired
    SessionFactory sessionFactory;

    protected Session session(){
        return sessionFactory.getCurrentSession();
    }
}

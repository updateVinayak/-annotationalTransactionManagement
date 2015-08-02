package com.spring4.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring4.model.Person;


@Repository
public class PersonDAOImpl implements PersonDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Person p) {
		
		Session session = this.sessionFactory.getCurrentSession();
        //Transaction tx = session.beginTransaction();
        session.save(p);
        //tx.commit();
        //session.close();
		
	}

	public List<Person> list() {
		
		Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        System.out.println("personList : " + personList);
        session.close();
        return personList;
		
		
	}

}

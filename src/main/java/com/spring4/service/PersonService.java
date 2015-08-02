package com.spring4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring4.dao.PersonDAO;
import com.spring4.model.Person;


@Component
public class PersonService {

	
	private PersonDAO personDAO;
	
	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	@Autowired
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Transactional (readOnly=false, rollbackFor=MyException.class)
	public void savePerson(Person p) throws MyException {
		personDAO.save(p);
		personDAO.list();
		//throw new MyException();
	}
	
	
}

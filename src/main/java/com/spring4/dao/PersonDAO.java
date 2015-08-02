package com.spring4.dao;

import java.util.List;

import com.spring4.model.Person;

public interface PersonDAO {

	public void save(Person p);
    
    public List<Person> list();
	
}

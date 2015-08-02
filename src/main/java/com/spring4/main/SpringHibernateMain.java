package com.spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring4.config.AppConfig;
import com.spring4.model.Person;
import com.spring4.service.MyException;
import com.spring4.service.PersonService;

public class SpringHibernateMain {

	public static void main(String[] args) {
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		Person person = new Person();
        person.setName("HP"); 
        person.setCountry("US");
        
        PersonService personService = context.getBean(PersonService.class);
        try {
			personService.savePerson(person);
		} catch (MyException e) {
			System.out.println("Catching..........");
			//e.printStackTrace();
		}
        
        /*
        PersonDAO personDAO = context.getBean(PersonDAOImpl.class);
        personDAO.save(person);
        List<Person> list = personDAO.list();        
        for(Person person1 : list){
        	System.out.println(person1.getName());
        }        
        System.out.println(list.size());
		*/
	}
	
}

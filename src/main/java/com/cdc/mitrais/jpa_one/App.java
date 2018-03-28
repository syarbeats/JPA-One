package com.cdc.mitrais.jpa_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdc.mitrais.jpa_one.entity.Employee;


public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);   
	
    public static void main( String[] args )
    {
    	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		/***********************************************
		 * ADD DATA USING JPA
		 * *********************************************/
		Employee employee =  new Employee();
		employee.setEid(1205);
		employee.setEname("Anand Singh");
		employee.setSalary(30000);
		employee.setDeg("Technical Lead");
		
		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();
		//entitymanager.close();
		//emFactory.close();
		
		/***********************************************
		 * EDIT DATA USING JPA
		 * *********************************************/
		entitymanager.getTransaction().begin();
		Employee employee1 = entitymanager.find(Employee.class, 1201);
		employee1.setSalary(48000);
		entitymanager.getTransaction().commit();

		/***********************************************
		 * FIND DATA USING JPA
		 * *********************************************/
		
		Employee employee2 = entitymanager.find(Employee.class, 1201);
		logger.debug("Name:"+employee2.getEname()+" Salary:"+employee2.getSalary());
		
		/***********************************************
		 * DELETE DATA USING JPA
		 * *********************************************/
		entitymanager.getTransaction().begin();
		Employee employee3 =  entitymanager.find(Employee.class, 1203);
		entitymanager.remove(employee3);
		entitymanager.getTransaction().commit();
		
		entitymanager.close();
		emFactory.close();
		
		
		
    }
}

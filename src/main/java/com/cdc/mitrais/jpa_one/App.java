package com.cdc.mitrais.jpa_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cdc.mitrais.jpa_one.entity.Employee;


public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager entitymanager = emFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Employee employee =  new Employee();
		employee.setEid(1202);
		employee.setEname("Takur Singh");
		employee.setSalary(56000);
		employee.setDeg("Senior Manager");
		
		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emFactory.close();
    }
}

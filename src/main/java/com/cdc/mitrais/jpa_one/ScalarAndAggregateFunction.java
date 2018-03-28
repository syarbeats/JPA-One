package com.cdc.mitrais.jpa_one;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdc.mitrais.jpa_one.entity.Employee;

public class ScalarAndAggregateFunction {

	public static void main(String[] args) {
		
		/**********************************************
		 * JAVA PERSISTENCE QUERY LANGUAGE(JPQL)
		 *********************************************/
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager entitymanager = emFactory.createEntityManager();
		
		Query query = entitymanager.createQuery("Select UPPER(e.ename) from Employee e");
		List<String> empList = query.getResultList();
		
		for(String e : empList) {
			System.out.println("Employee Name:"+e);
		}
		
		Query query1 = entitymanager.createQuery("Select e "+"from Employee e "+"where e.salary "+ "Between 30000 and 48000");
		List<Employee> list = (List<Employee>) query1.getResultList();
		
		for(Employee emp : list) {
			System.out.println("Employee ID:"+ emp.getEid());
			System.out.println("\t Employee Salary:"+emp.getSalary());
		}
		
		Query query2 = entitymanager.createQuery("Select e from Employee e where e.ename LIKE 'T%'");
		List<Employee> list2 = query2.getResultList();
		
		for(Employee emp : list2) {
			System.out.println("Employee Name:"+emp.getEname()+" Salary:"+emp.getSalary());
		}
		
		Query query3 = entitymanager.createQuery("Select e from Employee e ORDER BY e.ename ASC");
		List<Employee> list3 = query3.getResultList();
		
		for(Employee emp : list3) {
			System.out.println("Employe Name:"+emp.getEname());
		}
	}
}

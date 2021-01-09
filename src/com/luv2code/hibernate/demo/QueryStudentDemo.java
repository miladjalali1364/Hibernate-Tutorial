package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {

			
			// start a transaction
			session.beginTransaction();

			//  query student here student refere to table database
			List<Student> thestudent = session.createQuery("from Student").getResultList();
			
			
			//display the student
				
			displaystudent(thestudent);
			
			
			//query the student
			thestudent = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//dispaly the Student 
			System.out.println("\nPrint the Student with lastName:'Doe'");
			displaystudent(thestudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}
	
private static void displaystudent(List<Student> thestudents) {
	
	for (Student tempstudent : thestudents){
		System.out.println(tempstudent);
	}
	
	
}

}

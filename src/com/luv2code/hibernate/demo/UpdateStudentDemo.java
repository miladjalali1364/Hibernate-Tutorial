package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		

		// create session factory
		
		SessionFactory factory = new Configuration()
				                .configure()
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
				
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentid = 1;
			// now get a new session and start transaction
	        session = factory.getCurrentSession();
	        session.beginTransaction();
					
			
			// retrieve student based on the id: primary key
		
			
			Student mystudent = session.get(Student.class, studentid);
			System.out.println("\nGetting student with id: " + studentid);
			System.out.println("\nGet Completed: " + mystudent);
			System.out.println("\nUpdating...: ");
			
			mystudent.setFirstName("Milad");
			
			System.out.println("\nDone: " + mystudent);
			//commit the transaction
			session.getTransaction().commit();
				
			
			// New code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all student
			
			session.createQuery("update Student set email='foo@gmail.com' ")
			         .executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("\nDone: ");
			
			
		}finally {
			factory.close();
		}
	}

}

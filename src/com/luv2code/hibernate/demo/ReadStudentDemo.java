package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

import antlr.TokenStreamRetryException;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// create a student object
			System.out.println("Creating new student object");
			Student student = new Student("Hossien", "jalali", "jalali.Hossin@irib.ir");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student");
			System.out.println(student);
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

			//MY NEW CODE 
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id:" + student.getId());
			
			// now get a session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
					
			// retrieve student based on the id: primary kkey
			
			System.out.println("\nGetting student with id:"+ student.getId());
			Student mystudent = session.get(Student.class,student.getId());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");

		} finally {
			factory.close();
		}

		
	}
	


}

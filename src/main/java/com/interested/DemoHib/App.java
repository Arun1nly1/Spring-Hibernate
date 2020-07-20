package com.interested.DemoHib;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Initial code before relation mapping
    	
//     AlienName an = new AlienName();
//     an.setFname("Arun");
//     an.setLname("Chapagain");
//     an.setMname("Prasad");
//     Alien interested  = new Alien();
//     
//     
//     interested.setAid(500);
//     interested.setColor("Yellow");
//     interested.setAname(an);
//    
//     
//     Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
//     
//     SessionFactory sf = con.buildSessionFactory();
//     
//     
//     Session session = sf.openSession();
//     
//     Transaction tx = session.beginTransaction();
//     
//     session.save(interested);
//     
////   //Fetching data from database
////     interested = (Alien)session.get(Alien.class, 200);
//     
//     tx.commit();
//     
//     System.out.println(interested);
    	
    	
    	//RELATION MAPPING CODE
     	
    	
//   	Student s = new Student();    	
//   	s.setRollno(5);
//    s.setName("sameer");
//   	s.setMarks(95);
////    	For OneToOne relationship
////    	s.setLaptop(laptop);
//   	Laptop laptop = new Laptop();
//   	laptop.setLid(107);
//   	laptop.setLname("Mac");
//   	laptop.setStudent(s);
////    	For OneToMany relationship
//    	s.getLaptop().add(laptop);
//    	
   	
    	

    	
//    	
//    	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
//   		SessionFactory sf = config.buildSessionFactory();
//   		Session session = sf.openSession();
//   		
//   		session.beginTransaction();
   		
//    	Fetching values LAZY and EAGER
   		
//   		Student s1 = session.get(Student.class, 1);
//   		System.out.println(s1.getName());
//   		
//   		Collection<Laptop> laps = s1.getLaptop();
//   		for (Laptop l: laps) {
//   			System.out.println(l);
//   		}
//     
//  		session.save(s);
//   		session.save(laptop);
   		
//   		session.getTransaction().commit();
//   		
     
    	
//	 Hibernate Caching
    	
    	// First level caching
     	
//    	Person p = new Person();
//    	p.setId(4);
//    	p.setPname("Sanjeev");
//    	p.setColor("Blue");
    	
    	Person p =null;
    	Person q = null;
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);
		SessionFactory sf = config.buildSessionFactory();

    	Session session1 = sf.openSession();
   		
   		session1.beginTransaction();
   		
//   		p = (Person) session1.get(Person.class,1 );
//   		Same thing using query
   		Query q1 = session1.createQuery("from Person where id=1");
   		q1.setCacheable(true);

   		p = (Person)q1.uniqueResult();
   		System.out.println(p);
   		
   		session1.getTransaction().commit();
   		session1.close();
   		
   		
   		
    	Session session2 = sf.openSession();
    	session2.beginTransaction();
    	
//		Same thing using query
//   	q = (Person) session2.get(Person.class,1 );
		Query q2 = session2.createQuery("from Person where id=2");
   		q2.setCacheable(true);

		q = (Person)q2.uniqueResult();
				
		System.out.println(q);
   		session2.getTransaction().commit();
   		session2.close();

//   		session1.save(p);
   		
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}

package com.interested.DemoHib;

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
    	
     AlienName an = new AlienName();
     an.setFname("Arun");
     an.setLname("Chapagain");
     an.setMname("Prasad");
     Alien interested  = new Alien();
     
     
     interested.setAid(500);
     interested.setColor("Yellow");
     interested.setAname(an);
    
     
     Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
     
     SessionFactory sf = con.buildSessionFactory();
     
     
     Session session = sf.openSession();
     
     Transaction tx = session.beginTransaction();
     
     session.save(interested);
     
//   //Fetching data from database
//     interested = (Alien)session.get(Alien.class, 200);
     
     tx.commit();
     
     System.out.println(interested);
    }
}

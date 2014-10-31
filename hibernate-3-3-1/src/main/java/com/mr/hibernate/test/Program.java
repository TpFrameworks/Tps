package com.mr.hibernate.test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mr.hibernate.entities.*;



 public class Program 
{   public static void main( String[] args )
{	//Getting Session Factory
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	//Getting Session
Session session = sessionFactory.openSession();
//Beginning Transaction
Transaction tx = session.beginTransaction();
	//Creating two books with their author and publisher
	Authors aut1 = new Authors(0, "Alain BADIOU", "FR", new HashSet(0));
	Authors aut2 = new Authors(1, "Charles BUKOWSKI", "USA", new HashSet(0));
	
	Publishers p1 = new Publishers(0, "Circonstances, 5", new HashSet(0));
	Publishers p2 = new Publishers(1, "Le Livre de Poche", new HashSet(0));
	
	Books b1 = new Books(0, p1, "L'Hypothèse Communiste", 205, new HashSet(0));
	Books b2 = new Books(1, p2, "Contes de la folie ordinaire", 254, new HashSet(0));

	b1.getAuthorses().add(aut1);
	b1.setPublishers(p1);
	b2.getAuthorses().add(aut2);
	b2.setPublishers(p2);	
	
	System.out.print("f");
//Saving entities
session.save(aut1);
session.save(aut2);
	
session.save(p1);
session.save(p2);
	
session.save(b1);
session.save(b2);
	
//Committing and closing session 
tx.commit();
session.close();
}}


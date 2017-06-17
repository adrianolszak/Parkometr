package com.soa.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BiletService {
	   protected SessionFactory sessionFactory;
	   
	    protected void setup() {
	    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	    	        .configure() // configures settings from hibernate.cfg.xml
	    	        .build();
	    	try {
	    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    	    StandardServiceRegistryBuilder.destroy(registry);
	    	}
	    }
	 
	    protected void exit() {
	    	sessionFactory.close();
	    }
	 
	    public boolean create(String stan, String godzina, int nr_parkometru) {
	    	setup();
	    	Bilet bilet = new Bilet();
	    	bilet.setGodzina(godzina);
	    	bilet.setNr_parkometru(nr_parkometru);
	    	bilet.setStan(stan);

	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	     
	        session.save(bilet);
	     
	        session.getTransaction().commit();
	        session.close();
	        exit();
            return true;

	    }
	 
	    public List<Bilet> read() {
	    	try{
	    		setup();
	        Session session = sessionFactory.openSession();
	        List <Bilet> catlist = session.createCriteria(Bilet.class).list();

	        session.close();
	        exit();
	        return catlist;
	    	}
	    	finally {
	    		sessionFactory.close();
	    	}
	    }
	 
	    public boolean update(long id_biletu,String stan, String godzina, int nr_parkometru) {
	    	setup();
	    	Bilet bilet = new Bilet();
	    	bilet.setId_biletu(id_biletu);;
	    	bilet.setGodzina(godzina);
	    	bilet.setNr_parkometru(nr_parkometru);
	    	bilet.setStan(stan);
	    	
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	     
	        session.update(bilet);
	     
	        session.getTransaction().commit();
	        session.close();
	        exit();
            return true;

	    }
	 
	    public boolean delete(long id_biletu) {
	    	setup();
	    	Bilet bilet = new Bilet();
	    	  bilet.setId_biletu(id_biletu);
	    	  
	    	    Session session = sessionFactory.openSession();
	    	    session.beginTransaction();
	    	 
	    	    session.delete(bilet);
	    	 
	    	    session.getTransaction().commit();
	    	    session.close();
	    	    exit();
	            return true;

	    }

	    public static void main(String[] args) {
	  	  BiletService manager = new BiletService();

	      //manager.update(2,"Olszak","Adrian","Dzieje ...", "1234", 2015,19.99f);
	      //manager.delete(3);
manager.create("aktywny","12:30",1);
	      List<Bilet> list = manager.read();
	System.out.println(list.get(0).getId_biletu());
	    }
	}
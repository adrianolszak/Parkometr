package com.soa.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ParkingService {
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
	 
	    public boolean create(int nr_miejsca,String strefa,String ulica,String przyjazd) {
	    	setup();
	    	Parkingplaces Parkingplaces = new Parkingplaces();
	    	Parkingplaces.setNr_miejsca(nr_miejsca);
	    	Parkingplaces.setPrzyjazd(przyjazd);
	    	Parkingplaces.setStrefa(strefa);
	    	Parkingplaces.setUlica(ulica);

	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	     
	        session.save(Parkingplaces);
	     
	        session.getTransaction().commit();
	        session.close();
	        exit();	 
	        return true;
	    }
	 
	    public List<Parkingplaces> read() {
	    	try{
	    		setup();
	        Session session = sessionFactory.openSession();
	        List <Parkingplaces> catlist = session.createCriteria(Parkingplaces.class).list();
	        session.close();
	        exit();
	        return catlist;
	    	}
	    	finally {
	    		sessionFactory.close();
	    	}
	    }
	 
	    public boolean update(int nr_miejsca,String przyjazd) {
	    	setup();
	    	Session session = sessionFactory.openSession();
	    	Parkingplaces Parkingplaces = new Parkingplaces();
	    	List<Parkingplaces> lista = session.createCriteria(Parkingplaces.class).list();
	    	session.close();
	    	exit();
	    	setup();
	    	session = sessionFactory.openSession();
	    	for (Parkingplaces el : lista)if ((el.getNr_miejsca())== (nr_miejsca)){
	    	Parkingplaces.setId_miejsca(el.getId_miejsca());
	    	Parkingplaces.setPrzyjazd(przyjazd);
	    	Parkingplaces.setNr_miejsca(el.getNr_miejsca());
	    	Parkingplaces.setStrefa(el.getStrefa());
	    	Parkingplaces.setUlica(el.getUlica());
	        session.beginTransaction();
	        session.update(Parkingplaces);
	        session.getTransaction().commit();
	        session.close();
	        exit();
	        return true;
	    	}
	    	
	        exit();
	        return false;
	    }
	 
	    public boolean delete(long id_miejsca) {
	    	setup();
	    	Parkingplaces parkingplaces = new Parkingplaces();
	    	parkingplaces.setId_miejsca(id_miejsca);
	    	  
	    	    Session session = sessionFactory.openSession();
	    	    session.beginTransaction();
	    	 
	    	    session.delete(parkingplaces);
	    	 
	    	    session.getTransaction().commit();
	    	    session.close();
	    	    exit();
	            return true;
	    }
	}

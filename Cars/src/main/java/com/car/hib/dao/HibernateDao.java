package com.car.hib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class HibernateDao {
	
	protected static SessionFactory factory;
	
	static{
		try{
			factory = (new Configuration()).configure().buildSessionFactory();
		}catch(Throwable ex){
			System.out.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
		
	public abstract boolean create(Object o);
	public abstract List read();
	public abstract boolean update(Object o);
	public abstract boolean delete(Object o);
	
}

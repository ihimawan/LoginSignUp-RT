package com.car.hib.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.hib.dto.Car;

public class CarDao extends HibernateDao{

	@Override
	public boolean create(Object o) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			//get the transaction
			tx = session.beginTransaction();
			
			//do your thing
			Car car = (Car) o;
			session.save(car);

			//commit the transaction
			tx.commit();
			
		}catch (HibernateException e){ //if not thrown, then operation is successful.
			if (tx!=null){
				tx.rollback(); //return database to previous state
			}
			
			return false;
		}catch (ClassCastException e){
			System.out.println("Incorrect object that was passed in." + e);
			return false;
		}finally{
			session.close();
		}
		
		return true;
		
	}

	@Override
	public List read() {
		Session session = factory.openSession();
		Transaction tx = null;
		
		List<Car> list = null;
		
		try{
			
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from Car");
			list = (List<Car>) query.list();
			
			tx.commit();
			
		}catch(HibernateException e){
			if (tx!=null){
				tx.rollback();
			}
		}finally{
			session.close();
		}
		
		return list;
	}
	
	public List getCarsFilterByModel(String model){
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		List<Car> list = null;
		
		try{
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from Car where model=:m");
			query.setParameter("m", model);
			
			list = (List<Car>) query.list(); //will return empty list if nothing meets criteria.
			
			tx.commit();
			
		}catch(HibernateException e){
			if (tx!=null){
				tx.rollback();
			}
		}finally{
			session.close();
		}
		
		return list;
		
	}

	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}

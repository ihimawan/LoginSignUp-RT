package com.car.hib.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.hib.dto.Car;

public class CarDao extends HibernateDao{
	
	private static Logger log;
	
	public CarDao(){
		log = (Logger) LogManager.getLogger(CarDao.class);
	}

	@Override
	public boolean create(Object o) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			//get the transaction
			tx = session.beginTransaction();
			
			//do your thing
			Car car = (Car) o;

			session.saveOrUpdate(car);


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
			
			log.debug("Debug test from car");
			log.info("Read from Car table has begun");
			
			Query query = session.createQuery("from Car");
			list = (List<Car>) query.list();
			
			tx.commit();
			
			log.info("Read from Car table is successful");
			
		}catch(HibernateException e){
			
			log.error("Hibernate Exception has occured");
			
			if (tx!=null){
				tx.rollback();
				log.info("Transaction is rolled back.");
			}
			
		}finally{
			session.close();
		}
		
		return list;
	}

	@Override
	public boolean update(Object o) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			
			Car car = (Car) o;
			session.update(car);
			
			tx.commit();
			
			return true;
			
		}catch (HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}catch (ClassCastException e){
			System.out.println("Incorrect object passed.");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return false;
	}
	
	public Car getByVIN(String VIN){
		Session session = factory.openSession();
		Car result = null;
		
		try{
			result = session.get(Car.class, VIN);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	@Override
	public boolean delete(Object id) {
		String VIN = (String) id;
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			
			/*
			Criteria carCrit = session.createCriteria(Car.class);
			carCrit.add(Restrictions.eq("VIN", id));
			
			session.delete(carCrit.list().get(0));
			
			*/

			session.delete(session.get(Car.class, VIN));
			
			tx.commit();
			
			return true;
		}catch(IllegalArgumentException e){
			if (tx!=null) tx.rollback();
		}catch(Exception e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return false;
		
	}
	
	/*
	 * OTHER FUNCTIONS
	 */

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

}

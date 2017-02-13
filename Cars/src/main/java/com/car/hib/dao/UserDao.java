package com.car.hib.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.car.hib.dto.User;

public class UserDao extends HibernateDao{

	@Override
	public boolean create(Object o) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			//get the transaction
			tx = session.beginTransaction();
			
			//do your thing
			User user = (User) o;
			session.save(user);
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getEntryPassword(String username){
		
		Session session = factory.openSession();
		Transaction tx= null;
		
		String password = null;
		
		try{
			
			tx = session.beginTransaction();
			Query query = session.createQuery("from User where username = :u");
			query.setParameter("u", username);
			List<User> list = (List<User>) query.list();
			
			tx.commit();
			
			if (list!=null){
				password = list.get(0).getPassword();
	
			}
			
		}catch (HibernateException e){
			if (tx!=null){
				tx.rollback();
			}
			throw e;
		}catch(IndexOutOfBoundsException e){
			return password;
		}finally{
			session.close();
		}
		
		return password;
	}

}

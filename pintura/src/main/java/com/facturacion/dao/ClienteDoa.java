package com.facturacion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.facturacion.entitys.Cliente;
import com.facturacion.hibernate.HibernateUtil;

public class ClienteDoa {
	
	private static ClienteDoa instance;
	private ClienteDoa(){
		
	}
	public static ClienteDoa getInstance(){
		if(instance==null)
			instance = new ClienteDoa();
		return instance;
	}
	
	public void save(Cliente c){
		Session session = HibernateUtil.getSession();
		//Transaction tx = session.beginTransaction();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(c);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			HibernateUtil.shutdown();
		}
		
	}
	public void update(Cliente c){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			HibernateUtil.shutdown();
		}
	}
	public void delete(Cliente c){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();			 
			session.delete(get(c));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			HibernateUtil.shutdown();
		}
	}
	public Cliente get(Cliente c){
		Session session = HibernateUtil.getSession();
		Cliente result=null;
		try {
			List<Cliente> lista = session.createQuery("from com.facturacion.entitys.Cliente c where c.CUIL="+c.getCUIL()).list();
			if(lista.size()>0)
				result= lista.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.shutdown();
			return result;
		}
		
	}
	public List<Cliente> getAll(){
		Session session = HibernateUtil.getSession();
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			lista = session.createQuery("from com.facturacion.entitys.Cliente c").list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.shutdown();
			return lista;
		}
	}
	
	

}

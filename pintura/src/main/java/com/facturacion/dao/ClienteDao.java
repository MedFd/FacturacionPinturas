package com.facturacion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.facturacion.entitys.Cliente;
import com.facturacion.hibernate.HibernateUtil;


public class ClienteDao {
	
	private static ClienteDao instance;
	private ClienteDao(){
		
	}
	public static ClienteDao getInstance(){
		if(instance==null)
			instance = new ClienteDao();
		return instance;
	}
	
	public boolean save(Cliente c){
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
			return false;
		}
		finally{
			HibernateUtil.shutdown();
		}
		return true;
	}
	public boolean update(Cliente c){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
		finally{
			HibernateUtil.shutdown();
		}
		return true;
	}
	public boolean delete(Cliente c){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();			 
			session.delete(get(c));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
		finally{
			HibernateUtil.shutdown();
		}
		return true;
	}
	@SuppressWarnings("finally")
	public Cliente get(Cliente c){
		Session session = HibernateUtil.getSession();
		Cliente result=null;
		try {
			@SuppressWarnings("unchecked")
			List<Cliente> lista = session.createQuery("from com.facturacion.entitys.Cliente c where c.CUITCUIL="+c.getCUITCUIL()).list();
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
	@SuppressWarnings({ "finally", "unchecked" })
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
	@SuppressWarnings({ "unchecked", "finally" })
	public List<Cliente> getAllByName(String nombre, String apellido){
		Session session = HibernateUtil.getSession();
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			lista = session.createQuery("from com.facturacion.entitys.Cliente "+
					"WHERE nombre LIKE '" + nombre +"%' OR " +
					"nombre LIKE '%" + nombre +"%' OR " +
					"nombre LIKE '%"+ nombre +"' OR "
							+ "apellido LIKE '"+apellido+"%' OR "
							+ "apellido LIKE '%"+apellido+" %' OR "
							+ "apellido LIKE '%" +apellido+ "' "
							

					
					).list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.shutdown();
			return lista;
		}
	}
	

}

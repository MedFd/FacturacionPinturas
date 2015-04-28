package com.facturacion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.facturacion.entitys.Producto;
import com.facturacion.hibernate.HibernateUtil;


public class ProductoDao {
	
	private static ProductoDao instance;
	private ProductoDao(){
		
	}
	public static ProductoDao getInstance(){
		if(instance==null)
			instance = new ProductoDao();
		return instance;
	}
	
	public boolean save(Producto p){
		Session session = HibernateUtil.getSession();
		//Transaction tx = session.beginTransaction();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(p);
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
	public boolean update(Producto p){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(p);
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
	public boolean delete(Producto p){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();			 
			session.delete(get(p));
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
	public Producto get(Producto p){
		Session session = HibernateUtil.getSession();
		Producto result=null;
		try {
			@SuppressWarnings("unchecked")
			List<Producto> lista = session.createQuery("from com.facturacion.entitys.Producto id="+p.getId()).list();
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
	public List<Producto> getAll(){
		Session session = HibernateUtil.getSession();
		List<Producto> lista = new ArrayList<Producto>();
		try {
			lista = session.createQuery("from com.facturacion.entitys.Producto").list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.shutdown();
			return lista;
		}
	}
	@SuppressWarnings({ "unchecked", "finally" })
	public List<Producto> getAllByName(String desc){
		Session session = HibernateUtil.getSession();
		List<Producto> lista = new ArrayList<Producto>();
		try {
			lista = session.createQuery("from com.facturacion.entitys.Producto "+
					"WHERE descripcion LIKE '" + desc +"%' OR " +
					"nombre LIKE '%" + desc +"%' OR " +
					"nombre LIKE '%"+ desc +"'"
							+ "ORDER BY nombre DESC "
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

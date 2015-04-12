package com.facturacion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.facturacion.entitys.Proveedor;
import com.facturacion.hibernate.HibernateUtil;


public class ProveedorDao {
	private static ProveedorDao instancia;
	
	private ProveedorDao() {
		// constructor vacio
	}

	public static ProveedorDao getInstance() {
		if (instancia == null) {
			instancia = new ProveedorDao();
		}
		return instancia;
	}

	// insert
	public Boolean save(Proveedor c) {
		Boolean resultado;
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(c);
			tx.commit();
			// se guardo el registro
			resultado = true;
		} 
			catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			// no se guardo el registro
			resultado = false;
			
		} finally {
			HibernateUtil.shutdown();
		}
		return resultado;
	}

	// update
	public Boolean update(Proveedor c) {
		Boolean resultado;
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(c);
			tx.commit();
			// se guardaron los cambios
			resultado = true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			// no se guardaron los cambios
			resultado = false;
		} finally {
			HibernateUtil.shutdown();
		}
		return resultado;
	}

	// delete, no se usa
	public Boolean delete(Proveedor c) {
		Boolean resultado;
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();

			session.delete(get(c));
			tx.commit();
			resultado = true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			resultado = false;
		} finally {
			HibernateUtil.shutdown();
		}
		return resultado;
	}

	// obtener registro
	public Proveedor get(Proveedor c) {
		Session session = HibernateUtil.getSession();
		Proveedor result = null;
		try {

			result = (Proveedor) session.get(Proveedor.class, c.getId());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
		return result;
	}

	// obtener todos los registros, eliminados o no
	@SuppressWarnings("unchecked")
	public List<Proveedor> getAll() {
		Session session = HibernateUtil.getSession();
		List<Proveedor> lista = new ArrayList<Proveedor>();
		try {
			lista = session.createQuery("from com.facturacion.entitys.Proveedor c").list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
		return lista;
	}

}

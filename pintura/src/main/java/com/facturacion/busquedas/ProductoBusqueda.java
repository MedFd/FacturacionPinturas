package com.facturacion.busquedas;

import java.util.ArrayList;

import com.facturacion.dao.ClienteDao;
import com.facturacion.dao.ProductoDao;
import com.facturacion.entitys.Cliente;
import com.facturacion.entitys.Producto;
import com.facturacion.entitys.Proveedor;

public class ProductoBusqueda {
	
	private static ProductoBusqueda instancia;

	private ProductoBusqueda() {
		// constructor vacio
	}
	public static ProductoBusqueda getInstance() {
		if (instancia == null)
			instancia = new ProductoBusqueda();
		return instancia;
	}
	/*
	 * 
	 */
	public Long buscarIdPorObjeto(Producto item) {
		
		ArrayList<Producto> todosTrue = getInstance().getByEstadoTrue();
		for (Producto registro : todosTrue) {
			if (registro.equals(item) == true)
				return registro.getId();
		}
		return (long) 0;
	}
	/*
	 * 
	 */
	
	public ArrayList<Producto> getByID(String id){
		ArrayList<Producto> todos = (ArrayList<Producto>) ProductoDao.getInstance().getAll();
		ArrayList<Producto> rta = new ArrayList<Producto>();
		
		for (Producto item : todos) {
			if (item.getId().equals(id))
				rta.add(item);
		}
		return rta;
	}
	
	public ArrayList<Producto> getByNombre(String nombre){
		ArrayList<Producto> todos = (ArrayList<Producto>) ProductoDao.getInstance().getAllByName(nombre);
		ArrayList<Producto> rta = new ArrayList<Producto>();
		
		for (Producto item : todos) {
			if (item.isEstado()==true){
				rta.add(item);
			}				
		}
		return rta;
	}
	/*
	 * 
	 */
	public ArrayList<Producto> getByEstadoTrue(){
		return getByEstado(true);
	}
	public ArrayList<Producto> getByEstadoFalse(){
		return getByEstado(false);
	}
	public ArrayList<Producto> getByEstado(boolean estado){
		ArrayList<Producto> todos = (ArrayList<Producto>) ProductoDao.getInstance().getAll();
		ArrayList<Producto> rta = new ArrayList<Producto>();
		for (Producto item : todos) {
			if (item.isEstado() == estado)
				rta.add(item);
		}
		return rta;
	}
}

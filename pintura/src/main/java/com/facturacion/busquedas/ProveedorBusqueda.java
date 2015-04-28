package com.facturacion.busquedas;

import java.util.ArrayList;

import com.facturacion.dao.ProveedorDao;
import com.facturacion.entitys.Proveedor;

public class ProveedorBusqueda {

	private static ProveedorBusqueda instancia;

	private ProveedorBusqueda() {
		// constructor vacio
	}

	public static ProveedorBusqueda getInstance() {
		if (instancia == null)
			instancia = new ProveedorBusqueda();
		return instancia;
	}

	/**
	 * busca un registro con las mismas caracteriticas
	 * 
	 * @param item
	 * @return id del registro, "0" si no se encontro ninguno
	 */
	public Long buscarIdPorObjeto(Proveedor item) {
		
		ArrayList<Proveedor> todosTrue = getInstance().getRegistros_True();
		for (Proveedor registro : todosTrue) {
			if (registro.equals(item) == true)
				return registro.getId();
		}
		return (long) 0;
	}
	
	public ArrayList<Proveedor> buscarPorCUITCUIL(String cuil){
		ArrayList<Proveedor> todos = (ArrayList<Proveedor>) ProveedorDao.getInstance().getAll();
		ArrayList<Proveedor> rta = new ArrayList<Proveedor>();
		
		for (Proveedor item : todos) {
			if (item.getClave().equals(cuil))
				rta.add(item);
		}
		return rta;
	}

	/**
	 * obtener todos los registros segun su estado true-false
	 * 
	 * @param estado, true-false
	 * @return listado con el filtro del estado
	 */
	public ArrayList<Proveedor> buscarPorEstado(Boolean estado) {

		ArrayList<Proveedor> todos = (ArrayList<Proveedor>) ProveedorDao
				.getInstance().getAll();
		ArrayList<Proveedor> rta = new ArrayList<Proveedor>();

		for (Proveedor item : todos) {
			if (item.getEstado() == estado)
				rta.add(item);
		}
		return rta;
	}
	
	
	/**
	 * obtener todos los registros que estan activados
	 * @return listado con los registros
	 */
	public ArrayList<Proveedor> getRegistros_True() {
		return buscarPorEstado(true);
	}
	/**
	 * obtener todos los registros que estan desactivados
	 * @return listado con los registros
	 */
	public ArrayList<Proveedor> getRegistros_False() {
		return buscarPorEstado(false);
	}

	/**
	 * obtener todos los registros segun el nombre basado en lo que ingreso el
	 * cliente es decir, si escribio "es", se muestran los resultados que
	 * comienzan con "es" ej: estefania, esteban, esmeralda, etc
	 * 
	 * @param cadena por donde comienza
	 * @return listado con los resultados encontrados
	 */
	public ArrayList<Proveedor> buscarPorNombre(String patron) {

		ArrayList<Proveedor> rta = new ArrayList<Proveedor>();
		ArrayList<Proveedor> todosTrue = getInstance().getRegistros_True();

		for (Proveedor item : todosTrue) {
			if (item.getNombre().startsWith(patron) == Boolean.TRUE)
				rta.add(item);
		}
		return rta;
	}

}

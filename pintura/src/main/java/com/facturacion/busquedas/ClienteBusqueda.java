package com.facturacion.busquedas;

import java.util.ArrayList;

import com.facturacion.dao.ClienteDao;
import com.facturacion.entitys.Cliente;

public class ClienteBusqueda {

	private static ClienteBusqueda instancia;

	private ClienteBusqueda() {
		// constructor vacio
	}
	public static ClienteBusqueda getInstance() {
		if (instancia == null)
			instancia = new ClienteBusqueda();
		return instancia;
	}
	/**
	 * 
	 * 
	 * 
	 */
	public Long buscarIdPorObjeto(Cliente item) {
		
		ArrayList<Cliente> todosTrue = getInstance().getByEstadoTrue();
		for (Cliente registro : todosTrue) {
			if (registro.equals(item))
				return registro.getId();
		}
		return (long) 0;
	}
	public ArrayList<Cliente> getByNombre(String nombre,String apellido){
		ArrayList<Cliente> todos = (ArrayList<Cliente>) ClienteDao.getInstance().getAllByName(nombre, apellido);
		ArrayList<Cliente> rta = new ArrayList<Cliente>();
		
		for (Cliente item : todos) {
			if (item.isEstado()){
				rta.add(item);
			}
				
		}
		return rta;
	}
	public ArrayList<Cliente> getByCUITCUIL(String cuil){
		ArrayList<Cliente> todos = (ArrayList<Cliente>) ClienteDao.getInstance().getAll();
		ArrayList<Cliente> rta = new ArrayList<Cliente>();
		
		for (Cliente item : todos) {
			if (item.getCUITCUIL().equals(cuil))
				rta.add(item);
		}
		return rta;
	}
	public ArrayList<Cliente> getByEstadoTrue(){
		return getByEstado(true);
	}
	public ArrayList<Cliente> getByEstadoFalse(){
		return getByEstado(false);
	}
	public ArrayList<Cliente> getByEstado(boolean estado){
		ArrayList<Cliente> todos = (ArrayList<Cliente>) ClienteDao.getInstance().getAll();
		ArrayList<Cliente> rta = new ArrayList<Cliente>();
		for (Cliente item : todos) {
			if (item.isEstado() == estado)
				rta.add(item);
		}
		return rta;
	}
}

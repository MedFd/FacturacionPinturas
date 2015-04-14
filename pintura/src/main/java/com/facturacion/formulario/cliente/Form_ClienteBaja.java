package com.facturacion.formulario.cliente;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.facturacion.dao.ClienteDao;
import com.facturacion.entitys.Cliente;

public class Form_ClienteBaja {
	
	
	
	public void modificarEstado(String cuit){

		ArrayList<Cliente> lista = (ArrayList<Cliente>) ClienteDao.getInstance().getAll();
		for(Cliente cliente : lista){
				
			if(cliente.getCUITCUIL().equals(cuit)){
				
				if(cliente.isEstado()){
					bajaCliente(cliente);
					//MOSTRAR MENSAJE SE DESACTIVO CLIENTE
				}else{
					altaCliente(cliente);
					//MOSTRAR MENSAJE SE SACTIVO CLIENTE
				}

			}
		}
	}
	
	
	/*
	 * BAJA Y ALTA DE CLIENTE DEVUELVE UN BOOLEAN
	 */
	public void bajaCliente(Cliente cliente){	
		cliente.setEstado(false);
		ClienteDao.getInstance().update(cliente);
	}
	public void altaCliente(Cliente cliente){
		cliente.setEstado(true);
		ClienteDao.getInstance().update(cliente);
	}
	
}

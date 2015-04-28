package com.facturacion.formulario.cliente;

import java.util.ArrayList;

import javax.swing.JTable;

import com.facturacion.dao.ClienteDao;
import com.facturacion.entitys.Cliente;

public class Form_ClienteBaja extends Form_Cliente {
	
	
	
	public void modificarEstado(final Form_Cliente formC){

		JTable tablaCuil = formC.table;
		ArrayList<Cliente> lista = (ArrayList<Cliente>) ClienteDao.getInstance().getAll();
		try{
			for(Cliente cliente : lista){
				if(cliente.getCUITCUIL().equals(tablaCuil.getValueAt(tablaCuil.getSelectedRow(), 0).toString())){
						bajaCliente(cliente);
						actualizar(formC);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
	/*
	 * BAJA y ACTUALIZACION DEL FORM ANTERIOR
	 */
	public void bajaCliente(Cliente cliente){	
		cliente.setEstado(false);
		ClienteDao.getInstance().update(cliente);
	}
	private void actualizar(Form_Cliente p ){
		p.llenarJtablePorNombre();
		
	}
	
}

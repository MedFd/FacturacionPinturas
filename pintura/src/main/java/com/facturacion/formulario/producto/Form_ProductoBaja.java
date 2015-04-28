package com.facturacion.formulario.producto;

import java.util.ArrayList;

import javax.swing.JTable;

import com.facturacion.dao.ClienteDao;
import com.facturacion.dao.ProductoDao;
import com.facturacion.entitys.Cliente;
import com.facturacion.entitys.Producto;
import com.facturacion.formulario.cliente.Form_Cliente;

public class Form_ProductoBaja {

	public void modificarEstado(final Form_Producto formP){

		JTable tablaCuil = formP.table;
		ArrayList<Producto> lista = (ArrayList<Producto>) ProductoDao.getInstance().getAll();
		try{
			for(Producto pro : lista){
				if(pro.getId().equals(tablaCuil.getValueAt(tablaCuil.getSelectedRow(), 0).toString())){
						bajaProducto(pro);
						actualizar(formP);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
	/*
	 * BAJA y ACTUALIZACION DEL FORM ANTERIOR
	 */
	public void bajaProducto(Producto p){	
		p.setEstado(false);
		ProductoDao.getInstance().update(p);
	}
	private void actualizar(Form_Producto p ){
		p.llenarJtablePorNombre();
		
	}
}

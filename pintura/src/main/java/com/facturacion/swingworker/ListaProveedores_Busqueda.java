package com.facturacion.swingworker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingWorker;

import com.facturacion.busquedas.ProveedorBusqueda;
import com.facturacion.entitys.Proveedor;

public class ListaProveedores_Busqueda extends SwingWorker<ArrayList<Proveedor>, Void> {
	private String patron;
	private DefaultListModel modelo;
	private JList lista;
	
	public ListaProveedores_Busqueda(String patron, DefaultListModel modelo, JList lista) {
		this.patron = patron;
		this.modelo = new DefaultListModel();
		this.modelo = modelo;
		this.lista = new JList();
		this.lista.setModel(this.modelo);
	}

	@Override
	protected ArrayList<Proveedor> doInBackground() {
		modelo.removeAllElements();
		//lista.setSelectedIndex(-1);
		ArrayList<Proveedor> todos = new ArrayList<Proveedor>();
		if (patron == "")
			todos = ProveedorBusqueda.getInstance().getRegistros_True();
		else
			todos = ProveedorBusqueda.getInstance().buscarPorNombre(patron);
		
		for (Proveedor proveedor : todos) {
			modelo.addElement(proveedor);
		}
		return todos;
	}
	
	@Override
	protected void done() {
		try {
			ArrayList<Proveedor> array = get();
			lista.repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}

package com.facturacion.excepciones;

import javax.swing.JOptionPane;

public class CampoVacio extends Exception {
	
	private String campo;
	
	public CampoVacio(String campo) { 
		this.campo = campo;
	}
	
	public void mostrarMensaje() {
		JOptionPane.showMessageDialog(null, this.campo + ": campo vac�o", "Error", JOptionPane.ERROR_MESSAGE);
	}
}

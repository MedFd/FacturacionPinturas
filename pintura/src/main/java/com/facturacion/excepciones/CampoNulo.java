package com.facturacion.excepciones;

import javax.swing.JOptionPane;

public class CampoNulo extends Exception {
	
	private String campo;
	
	public CampoNulo(String campo) { 
		this.campo = campo;
	}
	
	public void mostrarMensaje() {
		JOptionPane.showMessageDialog(null, this.campo + ": campo nulo", "Error", JOptionPane.ERROR_MESSAGE);
	}
}

package com.facturacion.excepciones;

import javax.swing.JOptionPane;

public class CampoFormatoIncorrecto extends Exception {
	
	private String campo;
	private String caracteresPermitidos;
	
	public CampoFormatoIncorrecto(String campo, String caracteresPermitidos) {
		this.campo = campo;
		this.caracteresPermitidos = caracteresPermitidos;
	}
	
	public void mostrarMensaje() {
		JOptionPane.showMessageDialog(null, this.campo + 
				": formato incorrecto.\nSe permiten " + this.caracteresPermitidos, 
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	
}

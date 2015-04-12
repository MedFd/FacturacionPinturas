package com.facturacion.excepciones;

import javax.swing.JOptionPane;

public class CampoCantidadMinimaIncorrecta extends Exception {
	
	private String campo;
	private Integer cantidadCaracteresPermitidos;
	
	public CampoCantidadMinimaIncorrecta(String campo, Integer cantidadCaracteresPermitidos) {
		this.campo = campo;
		this.cantidadCaracteresPermitidos = cantidadCaracteresPermitidos;
	}
	
	public void mostrarMensaje() {
		JOptionPane.showMessageDialog(null, this.campo + 
				": cantidad de caracteres menor a la esperada.\nSe permiten al menos " + 
				this.cantidadCaracteresPermitidos.toString(), 
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	
}

package com.facturacion.excepciones;

import javax.swing.JOptionPane;

public class RegistroExistente extends Exception {
	
	private String clase;
	private Long id;
	
	public RegistroExistente(String clase, Long id) {
		this.clase = clase;
		this.id = id;
	}
	
	public void mostrarMensaje() {
		JOptionPane.showMessageDialog(null, "Registro de " + this.clase + 
				" existente. Id: " + this.id.toString(), "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
}

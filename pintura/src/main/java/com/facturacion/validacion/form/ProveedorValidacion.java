package com.facturacion.validacion.form;

import com.facturacion.validacion.ValidacionUtils;

public class ProveedorValidacion {
	
	public Boolean validarClave (String parte1, String parte2, String parte3) {
		if (!ValidacionUtils.tieneSoloNumero(parte1))
			return false;
		if (!ValidacionUtils.tieneSoloNumero(parte2))
			return false;
		if (!ValidacionUtils.tieneSoloNumero(parte3))
			return false;
		return true;
	}
	
	public Boolean validarNombre (String cadena) {
		if (!ValidacionUtils.tieneSoloLetras(cadena))
			return false;
		return true;
	}
	
	public Boolean validarTelefono (String cadena) {
		if (!ValidacionUtils.tieneFormatoTelefono(cadena))
			return false;
		return true;
	}
	
}

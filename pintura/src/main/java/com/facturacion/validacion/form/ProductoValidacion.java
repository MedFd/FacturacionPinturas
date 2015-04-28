package com.facturacion.validacion.form;

import com.facturacion.validacion.ValidacionUtils;

public class ProductoValidacion {
	
	
	public Boolean validarNombre (String cadena) {
		if (!ValidacionUtils.tieneSoloLetras(cadena))
			return false;
		return true;
	}
	public Boolean validarMarca (String cadena) {
		if (!ValidacionUtils.tieneSoloLetras(cadena))
			return false;
		return true;
	}
	public Boolean validarColor (String cadena) {
		if (!ValidacionUtils.tieneSoloNumero(cadena))
			return false;
		return true;
	}
	public Boolean validarStock (String cadena) {
		if (!ValidacionUtils.tieneSoloNumero(cadena))
			return false;		
		return true;
	}
	public Boolean validarPrecio (String cadena) {
		if (!ValidacionUtils.tieneSoloFloat(cadena))
			return false;		
		return true;
	}
	public Boolean validarLitros (String cadena) {
		if (!ValidacionUtils.tieneSoloFloat(cadena))
			return false;		
		return true;
	}

}

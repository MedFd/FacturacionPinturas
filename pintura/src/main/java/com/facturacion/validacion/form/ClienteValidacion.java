package com.facturacion.validacion.form;

import com.facturacion.validacion.ValidacionUtils;

public class ClienteValidacion {
	
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
	public Boolean validarApellido (String cadena) {
		if (!ValidacionUtils.tieneSoloLetras(cadena))
			return false;
		return true;
	}
	public Boolean validarLocalidad (String cadena) {
		if (!ValidacionUtils.tieneSoloLetras(cadena))
			return false;
		return true;
	}
	public Boolean validarTelefono (String cadena) {
		if (!ValidacionUtils.tieneFormatoTelefono(cadena))
			return false;
		return true;
	}
	public Boolean validarDescuento (String cadena) {
		if (!ValidacionUtils.tieneSoloNumero(cadena))
			return false;		
		return true;
	}
	/*
	 * VALIDACIONES NO OBLIGATORIAS
	 */
	public Boolean validarDueda (String cadena) {
		if (!ValidacionUtils.tieneSoloFloat(cadena))
			return false;		
		return true;
	}
	public Boolean validarMail(String cadena){
		if (!ValidacionUtils.tieneFormatoMail(cadena))
			return false;		
		return true;
	}
	public Boolean validarDireccion(String cadena){
		return true;
	}
}

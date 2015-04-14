package com.facturacion.validacion.form;

import com.facturacion.entitys.form.FormCliente;
import com.facturacion.entitys.form.FormProveedor;
import com.facturacion.excepciones.CampoCantidadMinimaIncorrecta;
import com.facturacion.excepciones.CampoFormatoIncorrecto;
import com.facturacion.excepciones.CampoNulo;
import com.facturacion.excepciones.CampoVacio;

public class FormClienteValidacion {

	public void validarFormulario_Clave(FormCliente formCliente) throws CampoNulo,CampoVacio,
	CampoCantidadMinimaIncorrecta,CampoFormatoIncorrecto {
		//cuil/cuit solo numeros
		ClienteValidacion pv = new ClienteValidacion();
		if (formCliente.getClaveParte1().equals(null) || formCliente.getClaveParte2().equals(null) || formCliente.getClaveParte3().equals(null))
			throw new CampoNulo("Cuit-cuil");
		if (formCliente.getClaveParte1().equals("") || formCliente.getClaveParte2().equals("") || formCliente.getClaveParte3().equals(""))
			throw new CampoVacio("Cuit-cuil");
		if (formCliente.getClaveParte1().length() < 2)
			throw new CampoCantidadMinimaIncorrecta("Cuit-cuil parte 1", 2);
		if (formCliente.getClaveParte2().length() < 8)
			throw new CampoCantidadMinimaIncorrecta("Cuit-cuil parte 2", 8);
		//no se necesita la validacion porque se ingresa solo un caracter
		//if (claveParte3.length() < 1)
			//throw new CampoCantidadMinimaIncorrecta("Cuit-cuil parte 3", 1);
		if (pv.validarClave(formCliente.getClaveParte1(), formCliente.getClaveParte2(), formCliente.getClaveParte3()) == false)
			throw new CampoFormatoIncorrecto("Cuit-cuil", "numeros");
	}
	
	public void validarFormulario_Nombre(FormCliente formCliente) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//nombre solo letras
		ClienteValidacion pv = new ClienteValidacion();
		if (formCliente.getNombre().equals(null))
			throw new CampoNulo("Nombre");
		if (formCliente.getNombre().equals(""))
			throw new CampoVacio("Nombre");
		if (pv.validarNombre(formCliente.getNombre()) == false)
			throw new CampoFormatoIncorrecto("Nombre", "letras");
	}
	public void validarFormulario_Apellido(FormCliente formCliente) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//nombre solo letras
		ClienteValidacion pv = new ClienteValidacion();
		if (formCliente.getApellido().equals(null))
			throw new CampoNulo("Apellido");
		if (formCliente.getApellido().equals(""))
			throw new CampoVacio("Apellido");
		if (pv.validarNombre(formCliente.getApellido()) == false)
			throw new CampoFormatoIncorrecto("Apellido", "letras");
	}
	
	public void validarFormulario_Telefono(FormCliente formCliente) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//telefono no debe ir letras
		ClienteValidacion pv = new ClienteValidacion();
		if (formCliente.getTelefono().equals(null))
			throw new CampoNulo("Telefono");
		if (formCliente.getTelefono().equals(""))
			throw new CampoVacio("Telefono");
		if (pv.validarTelefono(formCliente.getTelefono() ) == false)
			throw new CampoFormatoIncorrecto("Telefono", "numeros, guiones y parentesis");
	}
	public void validarFormulario_Descuento(FormCliente formCliente) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//telefono no debe ir letras
		ClienteValidacion pv = new ClienteValidacion();
		if (formCliente.getDescuento().equals(null))
			throw new CampoNulo("Descuento");
		if (formCliente.getDescuento().equals(""))
			throw new CampoVacio("Descuento");
		if (pv.validarDescuento(formCliente.getDescuento() ) == false)
			throw new CampoFormatoIncorrecto("Descuento", "numeros");
	}
	/*
	 * A PARTIR DE ACA LAS VALIDACIONES DE LOS CAMPOS NO NECESARIOS
	 */
	public void validarFormulario_Localidad(FormCliente formCliente) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//nombre solo letras
		ClienteValidacion pv = new ClienteValidacion();
		if (!formCliente.getLocalidad().equals(null) || formCliente.getLocalidad().equals("")){
			if (pv.validarLocalidad(formCliente.getLocalidad()) == false)
				throw new CampoFormatoIncorrecto("Localidad", "letras");
		}
	}
	public void validarFormulario_Deuda(FormCliente formCliente) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		ClienteValidacion pv = new ClienteValidacion();
		if (!formCliente.getDeuda().equals(null) || !formCliente.getDeuda().equals("") ){
			if (pv.validarDueda(formCliente.getDeuda()) == false)
				throw new CampoFormatoIncorrecto("Deuda", "numeros");
		}
	}
	public void validarFormulario_Mail(FormCliente formCliente) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		ClienteValidacion pv = new ClienteValidacion();
		if (!formCliente.getMail().equals(null) || !formCliente.getMail().equals("") ){
			if (pv.validarMail(formCliente.getMail()) == false)
				throw new CampoFormatoIncorrecto("Mail", "mail");
		}
	}
}

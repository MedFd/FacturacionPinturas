package com.facturacion.validacion.form;

import com.facturacion.entitys.form.FormProveedor;
import com.facturacion.excepciones.CampoCantidadMinimaIncorrecta;
import com.facturacion.excepciones.CampoFormatoIncorrecto;
import com.facturacion.excepciones.CampoNulo;
import com.facturacion.excepciones.CampoVacio;

public class FormProveedorValidacion {

	public void validarFormulario_Clave(FormProveedor formProveedor) throws CampoNulo,CampoVacio,
	CampoCantidadMinimaIncorrecta,CampoFormatoIncorrecto {
		//cuil/cuit solo numeros
		ProveedorValidacion pv = new ProveedorValidacion();
		if (formProveedor.getClaveParte1().equals(null) || formProveedor.getClaveParte2().equals(null) || formProveedor.getClaveParte3().equals(null))
			throw new CampoNulo("Cuit-cuil");
		if (formProveedor.getClaveParte1().equals("") || formProveedor.getClaveParte2().equals("") || formProveedor.getClaveParte3().equals(""))
			throw new CampoVacio("Cuit-cuil");
		if (formProveedor.getClaveParte1().length() < 2)
			throw new CampoCantidadMinimaIncorrecta("Cuit-cuil parte 1", 2);
		if (formProveedor.getClaveParte2().length() < 8)
			throw new CampoCantidadMinimaIncorrecta("Cuit-cuil parte 2", 8);
		//no se necesita la validacion porque se ingresa solo un caracter
		//if (claveParte3.length() < 1)
			//throw new CampoCantidadMinimaIncorrecta("Cuit-cuil parte 3", 1);
		if (pv.validarClave(formProveedor.getClaveParte1(), formProveedor.getClaveParte2(), formProveedor.getClaveParte3()) == false)
			throw new CampoFormatoIncorrecto("Cuit-cuil", "numeros");
	}
	
	public void validarFormulario_Nombre(FormProveedor formProveedor) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//nombre solo letras
		ProveedorValidacion pv = new ProveedorValidacion();
		if (formProveedor.getNombre().equals(null))
			throw new CampoNulo("Nombre");
		if (formProveedor.getNombre().equals(""))
			throw new CampoVacio("Nombre");
		if (pv.validarNombre(formProveedor.getNombre()) == false)
			throw new CampoFormatoIncorrecto("Nombre", "letras");
	}
	
	public void validarFormulario_Telefono(FormProveedor formProveedor) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//telefono no debe ir letras
		ProveedorValidacion pv = new ProveedorValidacion();
		if (formProveedor.getTelefono().equals(null))
			throw new CampoNulo("Telefono");
		if (formProveedor.getTelefono().equals(""))
			throw new CampoVacio("Telefono");
		if (pv.validarTelefono(formProveedor.getTelefono() ) == false)
			throw new CampoFormatoIncorrecto("Telefono", "numeros, guiones y parentesis");
	}
}

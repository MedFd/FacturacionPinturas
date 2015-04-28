package com.facturacion.validacion.form;

import com.facturacion.entitys.form.FormCliente;
import com.facturacion.entitys.form.FormProducto;
import com.facturacion.excepciones.CampoFormatoIncorrecto;
import com.facturacion.excepciones.CampoNulo;
import com.facturacion.excepciones.CampoVacio;

public class FormProductoValidacion {
	
	public void validarNombre(FormProducto formProducto) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//nombre solo letras
		ProductoValidacion pv = new ProductoValidacion();
		if (formProducto.getNombre().equals(null))
			throw new CampoNulo("Nombre");
		if (formProducto.getNombre().equals(""))
			throw new CampoVacio("Nombre");
		if (pv.validarNombre(formProducto.getNombre()) == false)
			throw new CampoFormatoIncorrecto("Nombre", "letras");
	}
	public void validarMarca(FormProducto formProducto) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//nombre solo letras
		ProductoValidacion pv = new ProductoValidacion();
		if (formProducto.getMarca().equals(null))
			throw new CampoNulo("Marca");
		if (formProducto.getMarca().equals(""))
			throw new CampoVacio("Marca");
		if (pv.validarMarca(formProducto.getMarca()) == false)
			throw new CampoFormatoIncorrecto("marca", "letras");
	}
	public void validarColor(FormProducto formProducto) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//nombre solo letras
		ProductoValidacion pv = new ProductoValidacion();
		if (formProducto.getColor().equals(null))
			throw new CampoNulo("Color");
		if (formProducto.getColor().equals(""))
			throw new CampoVacio("Color");
		if (pv.validarColor(formProducto.getColor()) == false)
			throw new CampoFormatoIncorrecto("Color", "numero");
	}
	public void validarStock(FormProducto formProducto) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		//telefono no debe ir letras
		ProductoValidacion pv = new ProductoValidacion();
		if (formProducto.getStock().equals(null))
			throw new CampoNulo("Stock");
		if (formProducto.getStock().equals(""))
			throw new CampoVacio("Stock");
		if (pv.validarStock(formProducto.getStock() ) == false)
			throw new CampoFormatoIncorrecto("Stock", "numeros");
	}
	public void validarPrecio(FormProducto formProducto) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		ProductoValidacion pv = new ProductoValidacion();
		if (formProducto.getPrecioVenta().equals(null))
			throw new CampoNulo("Precio");
		if (formProducto.getPrecioVenta().equals(""))
			throw new CampoVacio("Precio");
		if (pv.validarPrecio(formProducto.getPrecioVenta()) == false)
			throw new CampoFormatoIncorrecto("Precio", "numeros");
	}
	public void validarLitros(FormProducto formProducto) throws CampoNulo,CampoVacio,
	CampoFormatoIncorrecto {
		ProductoValidacion pv = new ProductoValidacion();
		if (formProducto.getLitros().equals(null))
			throw new CampoNulo("Litros");
		if (formProducto.getLitros().equals(""))
			throw new CampoVacio("Litros");
		if (pv.validarLitros(formProducto.getLitros()) == false)
			throw new CampoFormatoIncorrecto("Litros", "numeros");
	}
}

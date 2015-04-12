package com.facturacion.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.facturacion.entitys.form.FormProveedor;

@SuppressWarnings("serial")
@Entity (name="Proveedor")
public class Proveedor implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "clave", nullable = false)
	private String clave; //cuit-cuil
	
	@Column(length=45,nullable=false)
	private String nombre;
	
	@Column(length=45,nullable=true)
	private String direccion;
	
	@Column(length=15,nullable=true)
	private String telefono;
	
	@Column(nullable=false)
	private Boolean estado;
	
	public Proveedor() {
		//constructor vacio
	}
	
	public Proveedor(String clave, String nombre, String direccion, String telefono, Boolean estado) {
		this.clave = clave;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
	}
	
	public Proveedor(Long id, String clave, String nombre, String direccion, String telefono, Boolean estado) {
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
	}
	public Proveedor(FormProveedor form,Long id){
		this.id = id;
		this.clave = form.getClaveParte1()+"-"+form.getClaveParte2()+"-"+form.getClaveParte3();
		this.nombre = form.getNombre();
		this.direccion = form.getDireccion();
		this.telefono = form.getTelefono();
		this.estado = form.getEstado();
	}
	public Proveedor(FormProveedor form){
		this.clave = form.getClaveParte1()+"-"+form.getClaveParte2()+"-"+form.getClaveParte3();
		this.nombre = form.getNombre();
		this.direccion = form.getDireccion();
		this.telefono = form.getTelefono();
		this.estado = form.getEstado();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clave == null) ? 0 : clave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Proveedor other = (Proveedor) obj;
		if (clave == null) {
			if (other.clave != null) {
				return false;
			}
		} else if (!clave.equals(other.clave)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		//return "Proveedor [nombre=" + nombre + ", clave=" + clave + "]";
		return nombre + ", " + clave;
	}


	
	
	
}

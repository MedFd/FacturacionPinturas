package com.facturacion.entitys.form;

public class FormCliente {
	
	private Long id;
	private String claveParte1;
	private String claveParte2;
	private String claveParte3;
	private String nombre;
	private String apellido;
	private String direccion;
	private String localidad;
	private String telefono;
	private String mail;
	private String afiliacionSocial;
	private String descuento;
	private String deuda;
	private Boolean estado;
	/*
	 * GET AND SET
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClaveParte1() {
		return claveParte1;
	}
	public void setClaveParte1(String claveParte1) {
		this.claveParte1 = claveParte1;
	}
	public String getClaveParte2() {
		return claveParte2;
	}
	public void setClaveParte2(String claveParte2) {
		this.claveParte2 = claveParte2;
	}
	public String getClaveParte3() {
		return claveParte3;
	}
	public void setClaveParte3(String claveParte3) {
		this.claveParte3 = claveParte3;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAfiliacionSocial() {
		return afiliacionSocial;
	}
	public void setAfiliacionSocial(String afiliacionSocial) {
		this.afiliacionSocial = afiliacionSocial;
	}
	public String getDescuento() {
		return descuento;
	}
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	public String getDeuda() {
		return deuda;
	}
	public void setDeuda(String deuda) {
		this.deuda = deuda;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}

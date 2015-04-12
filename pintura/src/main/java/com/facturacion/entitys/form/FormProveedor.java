package com.facturacion.entitys.form;


public class FormProveedor {
	
	private Long id;
	private String claveParte1;
	private String claveParte2;
	private String claveParte3;
	private String nombre;
	private String direccion;
	private String telefono;
	private Boolean estado;
	/*
	 * CONTRUCTORES
	 */
	public FormProveedor(){
		
	}
	public FormProveedor(Long id, String claveParte1, String claveParte2,
			String claveParte3, String nombre, String direccion,
			String telefono, Boolean estado) {
		super();
		this.id = id;
		this.claveParte1 = claveParte1;
		this.claveParte2 = claveParte2;
		this.claveParte3 = claveParte3;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
	}
	public FormProveedor(String claveParte1, String claveParte2,
			String claveParte3, String nombre, String direccion, String telefono) {
		super();
		this.claveParte1 = claveParte1;
		this.claveParte2 = claveParte2;
		this.claveParte3 = claveParte3;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
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
	
}

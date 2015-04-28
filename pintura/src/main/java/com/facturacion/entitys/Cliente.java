package com.facturacion.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import com.facturacion.entitys.form.FormCliente;

@SuppressWarnings("serial")
@Entity
@Table(name="Cliente")
public class Cliente implements Serializable  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String CUITCUIL;
	@Column(length=45,nullable=false)
	private String nombre;
	@Column(length=45,nullable=false)
	private String apellido;
	@Column(length=45,nullable=true)
	private String direccion;
	@Column(length=45,nullable=true)
	private String localidad;
	@Column(length=15,nullable=false)
	private String telefono;
	@Column(length=25,nullable=true)
	private String mail;
	@Column(length=27,nullable=false)
	private String afiliacionSocial;
	@Column(nullable=false)
	private int descuento;
	@Column(nullable=false)
	private float deuda;
	@Column(nullable=false)
	private boolean estado;
	//=========================
	// Constructor
	//=========================
	public Cliente(){
		
	}
	public Cliente(FormCliente cliente,Long id){
		this.id=id;
		this.CUITCUIL=cliente.getClaveParte1()+"-"+cliente.getClaveParte2()+"-"+cliente.getClaveParte3();
		this.nombre=cliente.getNombre();
		this.apellido=cliente.getApellido();
		this.direccion=cliente.getDireccion();
		this.localidad=cliente.getLocalidad();
		this.telefono=cliente.getTelefono();
		this.mail=cliente.getMail();
		this.afiliacionSocial=cliente.getAfiliacionSocial();
		this.descuento=Integer.parseInt(cliente.getDescuento());
		this.deuda=Float.parseFloat(cliente.getDeuda());
		this.estado=cliente.getEstado();
	}
	public Cliente(FormCliente cliente){
		this.CUITCUIL=cliente.getClaveParte1()+"-"+cliente.getClaveParte2()+"-"+cliente.getClaveParte3();
		this.nombre=cliente.getNombre();
		this.apellido=cliente.getApellido();
		this.direccion=cliente.getDireccion();
		this.localidad=cliente.getLocalidad();
		this.telefono=cliente.getTelefono();
		this.mail=cliente.getMail();
		this.afiliacionSocial=cliente.getAfiliacionSocial();
		this.descuento=Integer.parseInt(cliente.getDescuento());
		this.deuda=Float.parseFloat(cliente.getDeuda());
		this.estado=cliente.getEstado();
	}
	/*
	 * 
	 */
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
		Cliente other = (Cliente) obj;
		if (CUITCUIL == null) {
			if (other.CUITCUIL != null) {
				return false;
			}
		} else if (!CUITCUIL.equals(other.CUITCUIL)) {
			return false;
		}
		return true;
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
	public String getCUITCUIL() {
		return CUITCUIL;
	}
	public void setCUITCUIL(String cUITCUIL) {
		CUITCUIL = cUITCUIL;
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
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public float getDeuda() {
		return deuda;
	}
	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
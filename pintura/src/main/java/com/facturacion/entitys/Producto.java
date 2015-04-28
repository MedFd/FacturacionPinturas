package com.facturacion.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.facturacion.entitys.form.FormProducto;

@Entity (name="Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=45,nullable=false)
	private String nombre;
	@Column(length=45,nullable=false)
	private String marca;
	@Column(length=15,nullable=false)
	private String color;
	@Column(nullable=false)
	private String codigo;
	@Column(nullable=false)
	private String aplicacion;
	@Column(nullable=false)
	private String envase;
	@Column(nullable=false)
	private float litros;
	@Column(nullable=false)
	private int stock;
	@Column(nullable=false)
	private float precioVenta;
	@Column(nullable=false)
	private boolean estado;
	/*
	 * 
	 */
	public Producto(Long id, FormProducto form){
		this.id=id;
		this.nombre=form.getNombre();
		this.color=form.getColor();
		this.codigo=form.getCodigo();
		this.aplicacion=form.getAplicacion();
		this.marca=form.getMarca();
		this.envase=form.getEnvase();
		this.litros=Float.parseFloat(form.getLitros());
		this.stock=Integer.parseInt(form.getStock());
		this.precioVenta=Float.parseFloat(form.getPrecioVenta());
		this.estado=form.getEstado();
	}
	public Producto(FormProducto form){
		this.nombre=form.getNombre();
		this.color=form.getColor();
		this.codigo=form.getCodigo();
		this.aplicacion=form.getAplicacion();
		this.marca=form.getMarca();
		this.envase=form.getEnvase();
		this.litros=Float.parseFloat(form.getLitros());
		this.stock=Integer.parseInt(form.getStock());
		this.precioVenta=Float.parseFloat(form.getPrecioVenta());
		this.estado=form.getEstado();
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
		Producto other = (Producto) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
	public String getEnvase() {
		return envase;
	}
	public void setEnvase(String envase) {
		this.envase = envase;
	}
	public float getLitros() {
		return litros;
	}
	public void setLitros(float litros) {
		this.litros = litros;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	

	
}

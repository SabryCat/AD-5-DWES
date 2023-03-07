package com.ite.zapateria.modelo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int idProducto;

	private String categoria;

	private String descripcion;

	private String nombre;

	private float precio;

	private int stock;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	

	public Producto(int idProducto, String categoria, String descripcion, String nombre, float precio, int stock) {
		super();
		this.idProducto = idProducto;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", categoria=" + categoria + ", descripcion=" + descripcion
				+ ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}

}
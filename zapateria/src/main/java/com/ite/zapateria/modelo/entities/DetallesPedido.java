package com.ite.zapateria.modelo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalles_pedido database table.
 * 
 */
@Entity
@Table(name="detalles_pedido")
@NamedQuery(name="DetallesPedido.findAll", query="SELECT d FROM DetallesPedido d")
public class DetallesPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle")
	private int idDetalle;

	private int cantidad;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	//uni-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	public DetallesPedido() {
	}

	public int getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
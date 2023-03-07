package com.ite.zapateria.modelo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to DetallesPedido
	@OneToMany(mappedBy="pedido", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<DetallesPedido> detallesPedidos;

	//uni-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name="id_direccion")
	private Direccion direccion;

	//uni-directional many-to-one association to Tarjeta
	@ManyToOne
	@JoinColumn(name="id_tarjeta")
	private Tarjeta tarjeta;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Usuario usuario;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<DetallesPedido> getDetallesPedidos() {
		return this.detallesPedidos;
	}

	public void setDetallesPedidos(List<DetallesPedido> detallesPedidos) {
		this.detallesPedidos = detallesPedidos;
	}

	public DetallesPedido addDetallesPedido(DetallesPedido detallesPedido) {
		getDetallesPedidos().add(detallesPedido);
		detallesPedido.setPedido(this);

		return detallesPedido;
	}

	public DetallesPedido removeDetallesPedido(DetallesPedido detallesPedido) {
		getDetallesPedidos().remove(detallesPedido);
		detallesPedido.setPedido(null);

		return detallesPedido;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
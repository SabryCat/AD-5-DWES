package com.ite.zapateria.modelo.dao;

import java.util.Date;
import java.util.List;

import com.ite.zapateria.modelo.entities.Pedido;

public interface PedidoDao {
	int altaPedido(Pedido pedido);
	Pedido buscarUno(int idPedido);
	List<Pedido> buscarPorDia(Date fecha);
	int salvarCarrito();

}

package com.ite.zapateria.modelo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.zapateria.modelo.entities.Pedido;
import com.ite.zapateria.repository.PedidoRepository;

@Service

public class PedidoDaoImpl implements PedidoDao{
	
	@Autowired
	PedidoRepository listaPedidos;

	@Override
	public int altaPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pedido buscarUno(int idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> buscarPorDia(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int salvarCarrito() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

package com.ite.zapateria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.zapateria.modelo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}

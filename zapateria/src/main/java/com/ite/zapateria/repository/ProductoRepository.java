package com.ite.zapateria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.zapateria.modelo.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
}

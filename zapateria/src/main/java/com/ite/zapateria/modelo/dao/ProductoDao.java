package com.ite.zapateria.modelo.dao;

import java.util.List;

import com.ite.zapateria.modelo.entities.Producto;

public interface ProductoDao {
	Producto altaProducto(Producto producto);
	void eliminarProducto(int idProducto);
	Producto modificarProducto(Producto producto);
	Producto buscarUno(int idproducto);
	List<Producto> buscarTodos();
}

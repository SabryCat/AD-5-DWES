package com.ite.zapateria.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.zapateria.modelo.entities.Producto;
import com.ite.zapateria.repository.ProductoRepository;

@Service
public class ProductoDaoImpl implements ProductoDao{
	
	@Autowired
	private ProductoRepository listaProductos;

	@Override
	public Producto altaProducto(Producto producto) {
		// TODO Auto-generated method stub
		if(buscarUno(producto.getIdProducto())==null)
			return listaProductos.save(producto);
		return null;
	}

	@Override
	public void eliminarProducto(int idProducto) {
		// TODO Auto-generated method stub
		if(buscarUno(idProducto)!=null)
			listaProductos.deleteById(idProducto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		// TODO Auto-generated method stub
		if(buscarUno(producto.getIdProducto())!=null)
			return listaProductos.save(producto);
		return null;
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return listaProductos.findAll();
	}


	@Override
	public Producto buscarUno(int idproducto) {
		// TODO Auto-generated method stub
		return listaProductos.findById(idproducto).orElse(null);
	}

}

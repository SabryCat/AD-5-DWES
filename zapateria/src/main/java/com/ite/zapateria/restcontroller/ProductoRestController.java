package com.ite.zapateria.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ite.zapateria.modelo.dao.ProductoDao;
import com.ite.zapateria.modelo.entities.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {
	@Autowired
	private ProductoDao listaProductos;
	
	@GetMapping("/precio/{id}")
	public double precioProducto(@PathVariable ("id") int idProducto) {
		return (listaProductos.buscarUno(idProducto).getPrecio());
	}
	@GetMapping("/categoria/{nombre}")
	public List<Producto> productosPorCategoria(@PathVariable ("nombre") String categoria){
		List<Producto> listado = new ArrayList<>();
		for(Producto p: listaProductos.buscarTodos()) {
			if (p.getCategoria().equalsIgnoreCase(categoria)){
				listado.add(p);
			}
		}
		return listado;
	}
	
}


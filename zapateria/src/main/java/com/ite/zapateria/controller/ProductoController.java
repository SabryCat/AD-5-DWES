package com.ite.zapateria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.zapateria.modelo.dao.ProductoDao;
import com.ite.zapateria.modelo.entities.Producto;

@RequestMapping("/productos")
@Controller
public class ProductoController {
	@Autowired
	private ProductoDao listaProductos;

	
	@GetMapping("/todos")
	public String buscarTodos(Model model){
		model.addAttribute("listaProductos", listaProductos.buscarTodos());
		return "productos";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable ("id") int idProducto) {
		
		Producto producto=listaProductos.buscarUno(idProducto);
		model.addAttribute("producto", producto);

		return "detalleproducto";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable ("id") int idProducto) {
		listaProductos.eliminarProducto(idProducto);
		return "redirect:/productos/todos";
	}
	
	@GetMapping("/alta")
	public String alta(Model model) {
		model.addAttribute("mensaje", "Da de alta un nuevo producto");
		return "gestionproducto";
	}
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable ("id") int idProducto, Model model, RedirectAttributes redirect) {
		Producto producto=listaProductos.buscarUno(idProducto);
		
		if(producto==null) {
			redirect.addFlashAttribute("info", "el producto no existe y no se puede modificar");
			return "redirect:/productos/todos";
		}
		
		model.addAttribute("mensaje", "Modifica el producto");
		model.addAttribute("producto", producto);
		return "gestionproducto";
	}
	@PostMapping("/alta")
	public String alta(@RequestParam String nombre,@RequestParam String descripcion, 
			@RequestParam float precio, @RequestParam String categoria, @RequestParam int stock, 
			Model model, RedirectAttributes redirect) {
		
		Producto producto = new Producto(0, categoria, descripcion, nombre, precio, stock);
		listaProductos.altaProducto(producto);
		redirect.addFlashAttribute("info", "producto dado de alta correctamente");
		return "redirect:/productos/todos";
	}
	@PostMapping("/modificar/{id}")
	public String modificar(@PathVariable ("id") int idProducto, @RequestParam String nombre,@RequestParam String descripcion, 
			@RequestParam float precio, @RequestParam String categoria, @RequestParam int stock, 
			Model model, RedirectAttributes redirect) {
		
		Producto producto=listaProductos.buscarUno(idProducto);
		
		if(producto==null) {
			redirect.addFlashAttribute("info", "el producto no existe y no se puede modificar");
			return "redirect:/productos/todos";
		}
		
		producto.setNombre(nombre);
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setCategoria(categoria);
		producto.setStock(stock);
		
		listaProductos.modificarProducto(producto);
		
		redirect.addFlashAttribute("info", "producto modificado correctamente");
		return "redirect:/productos/modificar/" + idProducto;
	}
}

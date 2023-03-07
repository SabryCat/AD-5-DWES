package com.ite.zapateria.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ite.zapateria.modelo.dao.ProductoDao;
import com.ite.zapateria.modelo.entities.Producto;


@Controller
public class HomeController {
	@Autowired
	private ProductoDao listaProductos;
	
	@GetMapping("/")
	public String home(Model model) {			
		List<Producto> lista = listaProductos.buscarTodos();		
		model.addAttribute("listaProductos", lista);		
		return "/index";		 		
	}
	
	@GetMapping("/registrado")
	public String procesarLogin() {	
		return "redirect:/";
	}
	
	
}

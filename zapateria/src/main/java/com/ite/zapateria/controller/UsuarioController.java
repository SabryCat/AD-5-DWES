package com.ite.zapateria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.zapateria.modelo.dao.RolDao;
import com.ite.zapateria.modelo.dao.UsuarioDao;
import com.ite.zapateria.modelo.entities.Role;
import com.ite.zapateria.modelo.entities.Usuario;
@RequestMapping("/usuarios")
@Controller
public class UsuarioController {

	@Autowired
	UsuarioDao listaUsuarios;
	@Autowired
	RolDao listaRoles;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/registro/cliente")
	public String registroCliente(Model model) {
		model.addAttribute("mensaje", "Regístrese como nuevo cliente");
		model.addAttribute("action", "cliente");
		return "registrousuarios";
	}
	@GetMapping("/registro/administrador")
	public String registroAdministrador(Model model) {
		model.addAttribute("mensaje", "Registre un nuevo administrador");
		model.addAttribute("action", "administrador");
		return "registrousuarios";
	}
	@PostMapping("/alta/cliente")
	public String altaCliente(@RequestParam String nombre, @RequestParam String apellido,@RequestParam String password, 
			@RequestParam String email, @RequestParam String telefono, Model model, RedirectAttributes redirect) {
		
		String encriptado = passwordEncoder.encode(password);  
		Role rolCliente=listaRoles.buscarRol(2);
		Usuario usuario = new Usuario(0, apellido, email, 1, nombre, encriptado, telefono, rolCliente, null, null);
		
		if(listaUsuarios.altaUsuario(usuario)==null) {
			redirect.addFlashAttribute("info", "Cliente ya existe. No se puede dar de alta");
		}else {
			redirect.addFlashAttribute("info", "Cliente dado de alta correctamente");
		}
		
		return "redirect:/productos/todos";
	}
	@PostMapping("/alta/administrador")
	public String altaAdministrador(@RequestParam String nombre, @RequestParam String apellido,@RequestParam String password, 
			@RequestParam String email, @RequestParam String telefono, Model model, RedirectAttributes redirect) {
		
		Role rolAdministrador=listaRoles.buscarRol(1);
		Usuario usuario = new Usuario(0, apellido, email, 1, nombre, password, telefono, rolAdministrador, null, null);
		
		if(listaUsuarios.altaUsuario(usuario)==null) {
			redirect.addFlashAttribute("info", "Administrador ya existe. No se puede dar de alta");
		}else {
			redirect.addFlashAttribute("info", "Administrador dado de alta correctamente");
		}
		
		return "redirect:/usuarios/registro/administrador";
	}
}

package com.ite.zapateria.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ite.zapateria.modelo.dao.UsuarioDao;
import com.ite.zapateria.modelo.entities.Direccion;
import com.ite.zapateria.modelo.entities.Usuario;

@RestController
@RequestMapping("/clientes")
public class UsuarioRestController {
	@Autowired
	private UsuarioDao listaUsuarios;
	
	@GetMapping("/provincia/{nombre}")
	public List<Usuario> clientesPorProvincia(@PathVariable ("nombre") String provincia){
		List<Usuario> clientesPorProvincia= new ArrayList<>();
		List<Usuario> usuarios = listaUsuarios.buscarTodos();
	
		for (Usuario u: usuarios) {
			List<Direccion> direcciones= u.getDirecciones();
			for (Direccion d: direcciones) {
				if (d.getLocalidad().equalsIgnoreCase(provincia) && u
						.getRole()
						.getNombre()
						.equalsIgnoreCase("cliente")) {
					
							clientesPorProvincia.add(u);
				}
			}
		}
	
		return clientesPorProvincia;
	}
}

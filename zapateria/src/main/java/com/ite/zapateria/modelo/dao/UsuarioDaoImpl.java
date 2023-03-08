package com.ite.zapateria.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ite.zapateria.modelo.entities.Direccion;
import com.ite.zapateria.modelo.entities.Tarjeta;
import com.ite.zapateria.modelo.entities.Usuario;
import com.ite.zapateria.repository.UsuarioRepository;

@Service
public class UsuarioDaoImpl implements UsuarioDao{

	@Autowired
	UsuarioRepository listaUsuarios;
	
	
	@Override
	public Usuario buscarByEmail(String email) {
		
		return listaUsuarios.buscarPorEmail(email);
	}

	@Override
	public Usuario buscarUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return listaUsuarios.findById(idUsuario).orElse(null);
	}

	@Override
	public void registrarTarjeta(Tarjeta tarjeta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resgistrarDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTarjeta(int idTarjeta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarDireccion(int idDireccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario altaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if(buscarUsuario(usuario.getIdUsuario())==null)
			try {
				return listaUsuarios.save(usuario);
			} catch(DataIntegrityViolationException e) {
				return null;
			}
		return null;
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return listaUsuarios.findAll();
	}

}

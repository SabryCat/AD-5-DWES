package com.ite.zapateria.modelo.dao;

import java.util.List;

import com.ite.zapateria.modelo.entities.Direccion;
import com.ite.zapateria.modelo.entities.Tarjeta;
import com.ite.zapateria.modelo.entities.Usuario;

public interface UsuarioDao {
	Usuario buscarByEmailAndPassword(String email, String password);
	Usuario buscarUsuario(int idUsuario);
	void registrarTarjeta(Tarjeta tarjeta);
	void resgistrarDireccion(Direccion direccion);
	void eliminarTarjeta(int idTarjeta);
	void eliminarDireccion(int idDireccion);
	Usuario altaUsuario(Usuario usuario);
	List<Usuario> buscarTodos();

}

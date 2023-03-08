package com.ite.zapateria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.zapateria.modelo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	@Query("select u from Usuario u where u.email=?1")
	public Usuario buscarPorEmail(String email);
}

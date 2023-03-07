package com.ite.zapateria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.zapateria.modelo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}

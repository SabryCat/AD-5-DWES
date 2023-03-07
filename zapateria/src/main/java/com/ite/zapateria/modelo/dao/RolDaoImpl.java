package com.ite.zapateria.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.zapateria.modelo.entities.Role;
import com.ite.zapateria.repository.RolRepository;

@Service
public class RolDaoImpl implements RolDao{
	@Autowired
	RolRepository listaRoles;
	
	@Override
	public Role buscarRol(int idRol) {
		return listaRoles.findById(idRol).orElse(null);
	}

}

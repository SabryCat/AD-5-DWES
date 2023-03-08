package com.ite.zapateria.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.zapateria.modelo.entities.Direccion;
import com.ite.zapateria.repository.DireccionRepository;

@Service
public class DireccionDaoImpl implements DireccionDao{

	@Autowired
	DireccionRepository listaDirecciones;
		
	@Override
	public Direccion altaDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		if(buscarDireccion(direccion.getIdDireccion())==null)
			return listaDirecciones.save(direccion);
		return null;
	}

	@Override
	public Direccion buscarDireccion(int idDireccion) {
		// TODO Auto-generated method stub
		return listaDirecciones.findById(idDireccion).orElse(null);
	}

}

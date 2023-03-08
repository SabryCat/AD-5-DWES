package com.ite.zapateria.modelo.dao;

import com.ite.zapateria.modelo.entities.Direccion;

public interface DireccionDao {
	Direccion altaDireccion(Direccion usuario);
	Direccion buscarDireccion(int idDireccion);
}

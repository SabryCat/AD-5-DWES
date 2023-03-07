package com.ite.zapateria.modelo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tarjetas database table.
 * 
 */
@Entity
@Table(name="tarjetas")
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tarjeta")
	private int idTarjeta;

	private int numero;

	private String titular;

	public Tarjeta() {
	}

	public int getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTarjeta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tarjeta))
			return false;
		Tarjeta other = (Tarjeta) obj;
		if (idTarjeta != other.idTarjeta)
			return false;
		return true;
	}

}
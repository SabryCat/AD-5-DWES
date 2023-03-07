package com.ite.zapateria.modelo.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	private String apellido;

	private String email;

	private int enabled;

	private String nombre;

	private String password;

	private String telefono;

	//uni-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Role role;

	//uni-directional many-to-many association to Direccion
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="usuarios_direcciones"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_direccion")
			}
		)
	private List<Direccion> direcciones;

	//uni-directional many-to-many association to Tarjeta
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="usuarios_tarjetas"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_tarjeta")
			}
		)
	private List<Tarjeta> tarjetas;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Direccion> getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	public void addDireccion(Direccion direccion) {
		if (direcciones == null)
			direcciones = new ArrayList<>();
		direcciones.remove(direccion);
	}
	
	public void removeDireccion(Direccion direccion) {
		if (direcciones ==null)
			direcciones = new ArrayList<>();
		direcciones.remove(direccion);
	}

	public List<Tarjeta> getTarjetas() {
		return this.tarjetas;
	}
	
	public void addTarjeta(Tarjeta tarjeta) {
		if (tarjetas == null)
			tarjetas = new ArrayList<>();
		tarjetas.add(tarjeta);
	}
	
	public void removeTarjeta(Tarjeta tarjeta) {
		if (tarjetas ==null)
			tarjetas = new ArrayList<>();
		tarjetas.remove(tarjeta);
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}
	

	public Usuario(int idUsuario, String apellido, String email, int enabled, String nombre, String password,
			String telefono, Role role, List<Direccion> direcciones, List<Tarjeta> tarjetas) {
		super();
		this.idUsuario = idUsuario;
		this.apellido = apellido;
		this.email = email;
		this.enabled = enabled;
		this.nombre = nombre;
		this.password = password;
		this.telefono = telefono;
		this.role = role;
		this.direcciones = direcciones;
		this.tarjetas = tarjetas;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apellido=" + apellido + ", email=" + email + ", enabled="
				+ enabled + ", nombre=" + nombre + ", password=" + password + ", telefono=" + telefono + ", role="
				+ role + ", direcciones=" + direcciones + ", tarjetas=" + tarjetas + "]";
	}

}
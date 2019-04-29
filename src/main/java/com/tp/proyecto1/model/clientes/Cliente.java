package com.tp.proyecto1.model.clientes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;

	@OneToOne(cascade = CascadeType.ALL)
	private Domicilio domicilio;

	private String email;
	private String telefono;
	private boolean isActivo;
	private LocalDate fechaBaja;
	private LocalDate fechaAlta;

	public Cliente() {
	}

	public Cliente(String nombre, String apellido, String dni, LocalDate fechaNacimiento, Domicilio domicilio, String email, String telefono, boolean isActivo, LocalDate fechaBaja, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.email = email;
		this.telefono = telefono;
		this.isActivo = isActivo;
		this.fechaBaja = fechaBaja;
		this.fechaAlta = fechaAlta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isActivo() {
		return isActivo;
	}

	public void setActivo(boolean activo) {
		isActivo = activo;
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cliente cliente = (Cliente) o;
		return isActivo == cliente.isActivo &&
				Objects.equals(id, cliente.id) &&
				Objects.equals(nombre, cliente.nombre) &&
				Objects.equals(apellido, cliente.apellido) &&
				Objects.equals(dni, cliente.dni) &&
				Objects.equals(fechaNacimiento, cliente.fechaNacimiento) &&
				Objects.equals(domicilio, cliente.domicilio) &&
				Objects.equals(email, cliente.email) &&
				Objects.equals(telefono, cliente.telefono) &&
				Objects.equals(fechaBaja, cliente.fechaBaja) &&
				Objects.equals(fechaAlta, cliente.fechaAlta);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, apellido, dni, fechaNacimiento, domicilio, email, telefono, isActivo, fechaBaja, fechaAlta);
	}
}
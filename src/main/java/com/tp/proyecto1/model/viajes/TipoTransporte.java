package com.tp.proyecto1.model.viajes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TipoTransporte {

	@Id
	@GeneratedValue
	private Long id;

	private String descripcion;

	public TipoTransporte() {
	}

	public TipoTransporte(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TipoTransporte that = (TipoTransporte) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(descripcion, that.descripcion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, descripcion);
	}
}

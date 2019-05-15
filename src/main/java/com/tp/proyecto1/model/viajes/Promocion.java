package com.tp.proyecto1.model.viajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.vaadin.flow.component.dialog.Dialog;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Promocion
{
	@Id
    @GeneratedValue
    protected Long id;
	
	protected String nombrePromocion;
	
	protected String descripcion;
	
	protected LocalDate fechaVencimiento;
	
	protected String codigoPromocion;
	
	protected Integer doubleValue;
	
	protected String tipoPromocion;
	
	protected Integer cantidadPasajes;
	
	@OneToMany
	protected Set<Viaje> viajesAfectados;
	
	@OneToMany
	protected Set<Destino> destinosAfectados;
	
	@OneToMany
	protected Set<TagDestino> tagsDestinoAfectados;
	
	public Promocion()
	{
		
	}
	
	public Promocion(String nombrePromocion, String descripcion, LocalDate fechaVencimiento, String codigoPromocion,Integer nroFloat, Integer cantidadPasajes2)
	{
		setNombrePromocion(nombrePromocion);
		setDescripcion(descripcion);
		setFechaVencimiento(fechaVencimiento);
		setCodigoPromocion(codigoPromocion);
		setDoubleValue(nroFloat);
		setCantidadPasajes(cantidadPasajes2);
		viajesAfectados = new TreeSet<Viaje>();
		destinosAfectados = new TreeSet<Destino>();
		tagsDestinoAfectados = new TreeSet<TagDestino>();
		
	}
	
	public Long getId()
	{
	        return id;
	}
	
	public void setId(Long id)
	{
	    this.id = id;
	}

	public String getNombrePromocion()
	{
		return nombrePromocion;
	}

	public void setNombrePromocion(String nombrePromocion)
	{
		this.nombrePromocion = nombrePromocion;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public LocalDate getFechaVencimiento()
	{
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento)
	{
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public String getCodigoPromocion()
	{
		return codigoPromocion;
	}

	public void setCodigoPromocion(String codigoPromocion)
	{
		this.codigoPromocion = codigoPromocion;
	}
	
	public Integer getDoubleValue()
	{
		return doubleValue;
	}

	public void setDoubleValue(Integer nroFloat)
	{
		this.doubleValue = nroFloat;
	}
	
	public String getTipoPromocion()
	{
		return tipoPromocion;
	}
	
	public void setTipoPromocion(String tipoPromocion)
	{
		this.tipoPromocion = tipoPromocion;
	}
	
	public Integer getCantidadPasajes()
	{
		return cantidadPasajes;
	}
	
	public void setCantidadPasajes(Integer cantidadPasajes2)
	{
		this.cantidadPasajes = cantidadPasajes2;
	}

	public Set<Destino> getDestinosAfectados()
	{
		return destinosAfectados;
	}
	
	public void setDestinosAfectados(Set<Destino> destinosAfectados)
	{
		this.destinosAfectados = destinosAfectados;
	}
	
	public Set<Viaje> getViajesAfectados()
	{
		return viajesAfectados;
	}
	
	public void setViajesAfectados(Set<Viaje> viajesAfectados)
	{
		this.viajesAfectados = viajesAfectados;
	}
	
	public Set<TagDestino> getTagsDestinoAfectados()
	{
		return tagsDestinoAfectados;
	}
	
	public void setTagsDestinoAfectados(Set<TagDestino> tagsDestinoAfectados)
	{
		this.tagsDestinoAfectados = tagsDestinoAfectados;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Promocion promocion = (Promocion) o;
		return
				Objects.equals(id, promocion.id) &&
				Objects.equals(nombrePromocion, promocion.nombrePromocion) &&
				Objects.equals(descripcion, promocion.descripcion) &&
				Objects.equals(fechaVencimiento, promocion.fechaVencimiento) &&
				Objects.equals(codigoPromocion, promocion.codigoPromocion) &&
				Objects.equals(doubleValue, promocion.doubleValue) &&
				Objects.equals(tipoPromocion, promocion.tipoPromocion) &&
				Objects.equals(cantidadPasajes, promocion.cantidadPasajes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombrePromocion, descripcion, fechaVencimiento, codigoPromocion,doubleValue,tipoPromocion,cantidadPasajes);
	}
	    
}

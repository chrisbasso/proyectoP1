package com.tp.proyecto1.model.lotePunto;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.tp.proyecto1.model.clientes.Cliente;

@Entity
public class LotePunto
{

	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDate fechaAlta;
	private LocalDate fechaVencimiento;
	private Integer cantidadPuntos;
	private Integer cantidadRestante;
	private Boolean isActivo;
	
	@ManyToOne
	private Cliente cliente;
	
	public LotePunto()
	{
		
	}
	
	public LotePunto(LocalDate fechaAlta, LocalDate fechaVencimiento, Integer cantidadPuntos, Boolean isActivo, Integer cantidadPuntosRestantes, Cliente cliente)
	{
		setFechaAlta(fechaAlta);
		setFechaVencimiento(fechaVencimiento);
		setCantidadPuntos(cantidadPuntos);
		setCantidadRestante(cantidadPuntosRestantes);
		setActivo(isActivo);
		setCliente(cliente);
	}

	public Long getId() {
		return id;
	}

	public Boolean getActivo() {
		return isActivo;
	}

	public void setActivo(Boolean activo) {
		isActivo = activo;
	}

	public LocalDate getFechaAlta()
	{
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta)
	{
		this.fechaAlta = fechaAlta;
	}

	public LocalDate getFechaVencimiento()
	{
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento)
	{
		this.fechaVencimiento = fechaVencimiento;
	}

	public Integer getCantidadPuntos()
	{
		return cantidadPuntos;
	}

	public void setCantidadPuntos(Integer cantidadPuntos)
	{
		this.cantidadPuntos = cantidadPuntos;
	}

	public Boolean getIsActivo()
	{
		return isActivo;
	}
	
	public Integer getCantidadRestante()
	{
		return cantidadRestante;
	}
	
	public void setCantidadRestante(Integer cantidadRestante)
	{
		this.cantidadRestante = cantidadRestante;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotePunto lotePunto = (LotePunto) o;
        return Objects.equals(id, lotePunto.id) &&
                Objects.equals(cantidadPuntos, lotePunto.cantidadPuntos) &&
                Objects.equals(cantidadRestante, lotePunto.cantidadRestante) &&
                Objects.equals(fechaAlta, lotePunto.fechaAlta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidadPuntos,cantidadRestante, fechaAlta);
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



}

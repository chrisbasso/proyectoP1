package com.tp.proyecto1.model.pasajes;

import com.tp.proyecto1.model.clientes.Cliente;
import com.tp.proyecto1.model.viajes.Viaje;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Transaccion {

	@Id
	@GeneratedValue
	protected Long id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	protected List<PasajeVenta> pasajes =  new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected List<Pago> pagos = new ArrayList<>();

	protected Double importeTotal;

	@OneToOne
	protected Viaje viaje;

	@OneToOne
	protected Cliente cliente;

	public Transaccion() {
	}

	public Transaccion(List<PasajeVenta> pasajes, List<Pago> pagos, Double importeTotal, Cliente cliente) {
		this.pasajes = pasajes;
		this.pagos = pagos;
		this.importeTotal = importeTotal;
		this.cliente = cliente;
	}

	public void agregarPago(Pago pago) {
		pagos.add(pago);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PasajeVenta> getPasajes() {
		return pasajes;
	}

	public void setPasajes(List<PasajeVenta> pasajes) {
		this.pasajes = pasajes;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Transaccion venta = (Transaccion) o;
		return Objects.equals(id, venta.id) &&
				Objects.equals(pasajes, venta.pasajes) &&
				Objects.equals(pagos, venta.pagos) &&
				Objects.equals(importeTotal, venta.importeTotal) &&
				Objects.equals(cliente, venta.cliente);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pasajes, pagos, importeTotal, cliente);
	}
}
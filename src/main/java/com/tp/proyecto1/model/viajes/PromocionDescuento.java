package com.tp.proyecto1.model.viajes;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class PromocionDescuento extends Promocion
{

	public PromocionDescuento()
	{
		
	}
	
	public PromocionDescuento(String nombrePromocion, String descripcion, LocalDate fechaVencimiento, String codigoPromocion, Double doubleValue, Double cantidadPasajes)
	{
		super(nombrePromocion, descripcion, fechaVencimiento, codigoPromocion,doubleValue,cantidadPasajes);
		setTipoPromocion("Descuento");

	}
	
	
}
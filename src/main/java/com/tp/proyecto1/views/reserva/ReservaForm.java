package com.tp.proyecto1.views.reserva;

import com.tp.proyecto1.model.clientes.Cliente;
import com.tp.proyecto1.model.viajes.Viaje;
import com.tp.proyecto1.utils.BuscadorClientesComponent;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class ReservaForm extends Dialog{

    private VerticalLayout mainLayout;
    private FormLayout form;
    private HorizontalLayout actions;
    private Viaje viaje;
    private TextField id;
	private TextField pais;
	private TextField ciudad;
	private TextField codTransporte;
	private TextField transporte;
	private TextField fecha;
	private TextField hora;
	private NumberField precioUnitario;
	private NumberField precioTotal;
	private BuscadorClientesComponent buscadorCliente;
	private Label lblDescripcionCliente;
	private NumberField cantidadPasajes;
	private NumberField sumaDePagos;
	private NumberField saldoPagar;
	private Button btnAgregarPago;
	private Button btnSave;
    private Button btnCancel;
    private Button btnComprar;

    public ReservaForm(Viaje viaje) {
    	if(viaje != null) {
    		this.viaje = viaje;
    		iniciliazarCampos();
    		cargarValores();
        	setReadOnly(); 
        	inicializarForm();
        	inicializarActions();        
        	inicializarMainLayout();	
    	}else {
    		// Prevenir que invoquen el form sin un viaje
    		Notification.show("Error al invocar ReservaForm.");
    	}		
    }

	private void iniciliazarCampos() {
		id = new TextField();  
		pais= new TextField();
		ciudad= new TextField();
		codTransporte= new TextField();
		transporte= new TextField();
		fecha = new TextField();
		hora = new TextField();
		precioUnitario= new NumberField();
		precioUnitario.setClassName(".v-numberfield");
		precioUnitario.setPrefixComponent(new Span("$"));
		lblDescripcionCliente = new Label();
		buscadorCliente = new BuscadorClientesComponent(lblDescripcionCliente);
		cantidadPasajes= new NumberField();		
		cantidadPasajes.setValue(1d);
		cantidadPasajes.setMin(1);
		cantidadPasajes.setMax(viaje.getPasajesRestantes());
		cantidadPasajes.setHasControls(true);
		precioTotal= new NumberField();
		precioTotal.setPrefixComponent(new Span("$"));
		sumaDePagos = new NumberField();		
		sumaDePagos.setPrefixComponent(new Span("$"));
		sumaDePagos.setMin(0.0);
		saldoPagar = new NumberField();
		saldoPagar.setPrefixComponent(new Span("$"));
		saldoPagar.setMin(0.0);
		btnAgregarPago = new Button("Agregar pago");
		btnAgregarPago.setEnabled(false);
	}

	private void cargarValores() {
		id.setValue(viaje.getId().toString());
    	pais.setValue(viaje.getCiudad().getPais().getNombre());
    	ciudad.setValue(viaje.getCiudad().getNombre());
    	codTransporte.setValue(viaje.getTransporte().getCodTransporte());
    	transporte.setValue(viaje.getTransporte().getTipo().getDescripcion());
    	fecha.setValue(viaje.getFechaSalida().toString());
    	hora.setValue(viaje.getHoraSalida().toString());
    	precioUnitario.setValue(viaje.getPrecio());
    	precioTotal.setValue(viaje.getPrecio());
    	saldoPagar.setValue(viaje.getPrecio());
	}
    
    private void setReadOnly() {
    	id.setReadOnly(true);  
		pais.setReadOnly(true);  
		ciudad.setReadOnly(true);  
		codTransporte.setReadOnly(true);  
		transporte.setReadOnly(true);  
		fecha.setReadOnly(true);
		hora.setReadOnly(true);
		precioUnitario.setReadOnly(true);
		precioTotal.setReadOnly(true);
		sumaDePagos.setReadOnly(true);
		saldoPagar.setReadOnly(true);
    }

	private void inicializarForm() {
		HorizontalLayout pagos = new HorizontalLayout();
		pagos.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.BASELINE);
		pagos.add(sumaDePagos, btnAgregarPago);
		
		form = new FormLayout();    	
    	form.addFormItem(pais, "País");
    	form.addFormItem(ciudad, "Ciudad");
    	form.addFormItem(codTransporte, "Cod Transporte");
    	form.addFormItem(transporte, "Transporte");
    	form.addFormItem(fecha, "Fecha");
    	form.addFormItem(hora, "Hora");
    	form.addFormItem(buscadorCliente, "Cliente");
    	form.addFormItem(lblDescripcionCliente,"Descripción");
    	form.addFormItem(cantidadPasajes, "Cantidad de pasajes");
    	form.addFormItem(precioUnitario, "Precio unitario");
    	form.addFormItem(precioTotal, "Precio Total");
    	form.addFormItem(saldoPagar, "Saldo");
    	form.addFormItem(pagos, "Pagos");    	
	}

	private void inicializarActions() {
		btnSave= new Button("Guardar");
		btnCancel= new Button("Cancelar");
		btnComprar= new Button("Comprar");
    	actions = new HorizontalLayout();
        actions.add(btnSave, btnCancel/*, btnComprar*/);//comente comprar ya que va a estar por ahora en la view de reservas
	}

	private void inicializarMainLayout() {
		mainLayout = new VerticalLayout();
    	mainLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        mainLayout.add(form,actions);
        mainLayout.setSizeFull();
    	this.add(mainLayout);
        this.setWidth("800px");
        this.setHeight("100%");
	}

	public Cliente getClienteSeleccionado() {
		return buscadorCliente.getCliente();
	}
	
	public double getPrecioTotal() {
		return precioTotal.getValue();
	}
	
	public Integer cantidadPasajesSeleccionados() {
		return cantidadPasajes.getValue().intValue();
	}
	
	public void actualizarPrecioTotal(double nuevoPrecTotal) {
		precioTotal.setReadOnly(false); 
		precioTotal.setValue(nuevoPrecTotal); 
		precioTotal.setReadOnly(true);
	}
	
	public void actualizarPagos(double nuevoPagos) {
		sumaDePagos.setReadOnly(false); 
		sumaDePagos.setValue(nuevoPagos); 
		sumaDePagos.setReadOnly(true);
	}	
	
	public boolean pagoEsMayorQueTotal() {
		if(sumaDePagos.getValue() != null) {
			return sumaDePagos.getValue() > precioTotal.getValue();
		}else {
			return false;
		}		
	}
	
	public void reiniciarPagoIngresado() {
		sumaDePagos.setReadOnly(false);
		sumaDePagos.setValue(0.0);
		sumaDePagos.setReadOnly(true);
	}
	
	public void actualizarSaldo(double saldo) {
		saldoPagar.setReadOnly(false);
		saldoPagar.setValue(saldo);
		saldoPagar.setReadOnly(true);
	}
	
	public void habilitarBtnAgregarPago() {
		btnAgregarPago.setEnabled(true);
	}
	
	public void deshabilitarBtnAgregarPago() {
		btnAgregarPago.setEnabled(false);
	}
	
	public void inhabilitarClientes(){
		buscadorCliente.getFiltro().setReadOnly(true);
	}
	
	public void setModoModificacion(double pasajes, Cliente cliente, double pago) {
		buscadorCliente.getFiltro().setReadOnly(false);
		buscadorCliente.getFiltro().setValue(cliente.getId().toString());
		buscadorCliente.getFiltro().setReadOnly(true);
		cantidadPasajes.setValue(pasajes);	
		precioTotal.setValue(pasajes * viaje.getPrecio());
		actualizarPagos(pago);
		habilitarBtnAgregarPago();
	}
	
	public void setListenerCantPasajes(ValueChangeListener<? super ComponentValueChangeEvent<NumberField, Double>> e) {
		cantidadPasajes.addValueChangeListener(e);
	}
	
	public void setListenerBtnNuevoPago(ComponentEventListener<ClickEvent<Button>> e) {
		btnAgregarPago.addClickListener(e);
	}

	public BuscadorClientesComponent getBuscadorCliente() {
		return buscadorCliente;
	}

	public void setBuscadorCliente(BuscadorClientesComponent buscadorCliente) {
		this.buscadorCliente = buscadorCliente;
	}

	public void setListenerBtnSave(ComponentEventListener<ClickEvent<Button>> e) {
		btnSave.addClickListener(e);
	}	
	
	public void setListenerBtnCancel(ComponentEventListener<ClickEvent<Button>> e) {
		btnCancel.addClickListener(e);
	}	
}
package com.tp.proyecto1.views.reserva;

import java.util.List;

import com.tp.proyecto1.model.pasajes.FormaDePago;
import com.tp.proyecto1.model.pasajes.Pago;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class AgregarPagoForm extends Dialog{

	private VerticalLayout mainLayout;
	private NumberField pago;     
	private ComboBox<FormaDePago> cmbFormaPago;	
    private HorizontalLayout etiquetas;
    private Grid pagosAnteriores;
    private FormLayout form;
    private Button btnGuardar;
    private Button btnCancelar;
    private Button btnAgregar;
    private HorizontalLayout actions;
	private Double importeMaximo;
	
	/*
	 * Iniciar con el pago máximo para validar en el form que la 
	 * suma de pagos no se exceda. 	
	 */
    public AgregarPagoForm(Double importeMaximo) {
    	this.importeMaximo = importeMaximo;
		iniciliazarCampos();
    	inicializarForm();
    	inicializarActions();
    	inicializarEtiquetas();
    	inicializarGridPagos();
    	inicializarMainLayout();    	
    }
    /*
     * Inicializar el combo y el field para pagos.
     */
	private void iniciliazarCampos() {		
		cmbFormaPago = new ComboBox<FormaDePago>();
		pago = new NumberField();
		pago.setPrefixComponent(new Span("$"));
		pago.setMin(0.0);
		pago.setMax(importeMaximo);
	}
	/*
	 * Form para pago y combo de pagos. 
	 */
	private void inicializarForm() {
		form = new FormLayout();    	
    	form.addFormItem(pago, "Importe");
    	form.addFormItem(cmbFormaPago, "Forma de Pago");
    	btnAgregar = new Button("", VaadinIcon.PLUS.create());
    	form.addFormItem(btnAgregar,"");
	}
	/*
	 * Cargar botones.
	 */
	private void inicializarActions() {
		btnGuardar= new Button("Guardar");
		btnGuardar.setEnabled(false);
		btnCancelar= new Button("Cancelar");
    	actions = new HorizontalLayout();
        actions.add(btnGuardar, btnCancelar);
	}
	/*
	 * Cargar grid con detalle de pagos.
	 */
	private void inicializarGridPagos() {
		pagosAnteriores = new Grid<>(Pago.class);
		pagosAnteriores.addThemeVariants(GridVariant.MATERIAL_COLUMN_DIVIDERS);
		pagosAnteriores.setSelectionMode(Grid.SelectionMode.NONE);
		pagosAnteriores.setHeightByRows(true);
		pagosAnteriores.setColumns("transaccion", "formaDePago", "importe", "fechaDePago");
		pagosAnteriores.getColumnByKey("transaccion").setVisible(false);
		pagosAnteriores.getColumnByKey("formaDePago").setHeader("Medio");
		
	}
	/*
	 * Etiquetas de texto para mostrar los pagos ingresados y el saldo por pagar.
	 */
	private void inicializarEtiquetas() {
		etiquetas = new HorizontalLayout();
		Text saldo = new Text("Por pagar: " + importeMaximo.toString());
		Text sumaDePagos = new Text("Pagado: ");
		etiquetas.addComponentAtIndex(0, saldo);
		etiquetas.addComponentAtIndex(1,sumaDePagos);		
	}
	/*
	 * Intenté mostrar y ocultar las etiquetas...
	 */
	public void mostrarEtiquetaSumaDePagos(Double suma) {		
		etiquetas.getComponentAt(1).getElement().setText("Pagado: " + suma.toString());
		etiquetas.getComponentAt(1).setVisible(true);		
	}
	/*
	 * Intenté mostrar y ocultar las etiquetas...
	 */	
	public void ocultarEtiquetaSumaDePagos() {
		etiquetas.getComponentAt(1).setVisible(false);
	}
	/*
	 * Contenedor principal de todos los elementos
	 */
	private void inicializarMainLayout() {		
		mainLayout = new VerticalLayout();
    	mainLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        mainLayout.add(form,etiquetas,pagosAnteriores,actions);
        mainLayout.setSizeFull();
    	this.add(mainLayout);
        this.setWidth("800px");
        this.setHeight("80%");
	}
	/*
	 * Cargar valores en el combo de formas de pago..
	 */
	public void cargarFormasDePago(List <FormaDePago> fdp) {
		cmbFormaPago.setItems(fdp);
	}
	/*
	 * Cargar valores en el grid de pagos anteriores..
	 */	
	public void cargarPagosAnteriores(List <Pago> pagos) {
		pagosAnteriores.setItems(pagos);		
	}
	/*
	 * Captar forma de pago seleccionada.
	 */
	public FormaDePago getFormaPagoSeleccionada() {
		return cmbFormaPago.getValue();
	}
	/*
	 * Captar importe de pago ingresado.
	 */	
	public Double getPagoIngresado() {
		if(pago.getValue() == null) {
			return 0.00;
		}else {
			return pago.getValue();
		}
	}
	/*
	 * Actualizar el importe máximo para el siguiente pago.
	 */
	public void actualizarPagoMaximo(Double nuevoImporte) {
		pago.setValue(0.0);
		pago.setMax(nuevoImporte);
	}
	/*
	 * Habilitar el botón guardar.
	 */
	public void activarBtnGuardar() {
		btnGuardar.setEnabled(true);		
	}
	/*
	 * Deshabilitar el botón guardar.
	 */	
	public void desactivarBtnGuardar() {
		btnGuardar.setEnabled(false);
	}
	
	public void setListenerImporte(ValueChangeListener<? super ComponentValueChangeEvent<NumberField, Double>> e) {
		pago.addValueChangeListener(e);
	}
	
	public void setListenerFDP(ValueChangeListener<? super ComponentValueChangeEvent<ComboBox<FormaDePago>, FormaDePago>> e) {
		cmbFormaPago.addValueChangeListener(e);
	}
	
	public void setListenerBtnGuardar(ComponentEventListener<ClickEvent<Button>> e){
		btnGuardar.addClickListener(e);
	}
	
	public void setListenerBtnCancelar(ComponentEventListener<ClickEvent<Button>> e){
		btnCancelar.addClickListener(e);
	}
	
	public void setListenerBtnAgregar(ComponentEventListener<ClickEvent<Button>> e){
		btnAgregar.addClickListener(e);
	}
}
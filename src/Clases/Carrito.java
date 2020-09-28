package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito> lstItemCarrito;
	private Entrega entrega;
	
	//Constructor
	
	
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente, Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = 0;
		this.cliente = cliente;
		this.lstItemCarrito = new ArrayList<ItemCarrito>();
		this.entrega = entrega;
	}
	
	//Getters y setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public double getDescuento() {
		return descuento;
	}

	protected void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}

	public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	
	//metodos de clase
	
	public boolean agregar(Articulo articulo, int cantidad) {
		
		boolean existe = false;
		
		for(ItemCarrito i: this.lstItemCarrito) {
			if(i.getArticulo().equals(articulo)) {
				existe = true;
				i.setCantidad(i.getCantidad()+cantidad);
			}
		}
		if(!existe) {
			this.lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
		}
		return true;
	}
	
	public void sacar(Articulo articulo, int cantidad) throws Exception{
		
		boolean exito = false;
	
		for(ItemCarrito i: this.lstItemCarrito) {
			if(i.getArticulo().equals(articulo)) {
				if(cantidad < i.getCantidad()) {
					i.setCantidad(i.getCantidad()-cantidad);
				}
				else {
					this.lstItemCarrito.remove(i);					
				}
				exito = true;
			}
		}
		if(!exito)
			throw new Exception ("El articulo no existe en el carrito.");	
	}
	
	
	public double calcularTotalCarrito() {
		
		double  total = 0;
		
		for(ItemCarrito i: this.lstItemCarrito) {
			total+=(i.calcularSubTotalItem());
		}
		
		return total;
	}
	
	public boolean equals(Carrito carrito) {
		if(this.cliente.equals(carrito.cliente)) {
			return true;
		}
		return false;
	}
	
	public void calcularDescuentoCarrito(int diaDescuento, double porcentajeDescuento, double porcentajeDescuentoEfectivo) {
		double descuento = 0;
		descuento += calcularDescuentoDia(diaDescuento, porcentajeDescuento);
		descuento += calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
		this.setDescuento(descuento);
	}
	
	public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuento) {
		
		double descuento = 0;
		
		if(diaDescuento == this.fecha.getDayOfWeek().getValue()) {
			descuento = this.calcularTotalCarrito()*(porcentajeDescuento/100);
		}
		
		return descuento;
	}
	
	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		return this.calcularTotalCarrito()*(porcentajeDescuentoEfectivo/100);
	}
	
	public double totalAPagarCarrito() {
		return calcularTotalCarrito() - descuento;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", cerrado=" + cerrado + ", descuento="
				+ descuento + ", cliente=" + cliente + ", lstItemCarrito=" + lstItemCarrito + ", entrega=" + entrega
				+ "]";
	}

}

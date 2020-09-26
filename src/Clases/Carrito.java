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
		this.descuento = descuento;
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

	public void setDescuento(double descuento) {
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
		
		//Verificar que no exista un item para ese articulo
		
		for(ItemCarrito i: this.lstItemCarrito) {
			if(i.getArticulo().equals(articulo)) {
				i.setCantidad(i.getCantidad()+cantidad);
			}
			else {
				this.lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
			}
		}		
		return true;
	}
	
	public boolean sacar(Articulo articulo, int cantidad) throws Exception{
		
		for(ItemCarrito i: this.lstItemCarrito) {
			if(i.getArticulo().equals(articulo)) {
				if(cantidad < i.getCantidad()) {
					i.setCantidad(i.getCantidad()-cantidad);
					return true;
				}
				else {
					this.lstItemCarrito.remove(i);
					return true;
				}
			}
		}
		throw new Exception ("El articulo no existe en el carrito.");		
	}
	
	public double calcularTotalCarrito() {
		
		double  total = 0;
		
		for(ItemCarrito i: this.lstItemCarrito) {
			total+=(i.calcularSubTotalItem());
		}
		
		return total;
	}
	

}

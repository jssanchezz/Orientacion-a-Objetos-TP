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
	
	public Carrito(int id, LocalDate fecha, LocalTime hora, Cliente cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = false;
		this.descuento = 0;
		this.cliente = cliente;
		this.lstItemCarrito = new ArrayList<ItemCarrito>();
		this.entrega = null;
	}
	
	public Carrito(int id, LocalDate fecha, LocalTime hora, Cliente cliente, Entrega entrega) {
		
		this(id, fecha, hora, cliente);
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
	
	public boolean agregar(Articulo articulo, int cantidad) throws Exception{
		
		if(articulo == null) throw new Exception("Articulo inválido (no existe)");
		if(this.isCerrado()) throw new Exception("El carrito se encuentra cerrado.");
		
		ItemCarrito aux = traerItem(articulo);
		if(aux!=null) {
			aux.setCantidad(aux.getCantidad()+cantidad);
		}
		else {
			this.lstItemCarrito.add(new ItemCarrito(articulo,cantidad));
		}
		return true;
	}
	
	private ItemCarrito traerItem(Articulo articulo) {
		ItemCarrito aux = null;
		int i = 0;
		while(aux == null && i < this.lstItemCarrito.size()) {
			if(this.lstItemCarrito.get(i).getArticulo().equals(articulo)) {
				aux = this.lstItemCarrito.get(i);
			}
			i++;
		}
		return aux;
	}
	
	public boolean sacar(Articulo articulo, int cantidad) throws Exception{
		
		ItemCarrito aux = traerItem(articulo);
		if(aux==null) {
			throw new Exception ("No existe el articulo en el carrito.");
		}
		
		aux.setCantidad(aux.getCantidad()-cantidad);
		if(aux.getCantidad()<1) {
			this.lstItemCarrito.remove(aux);
		}
		return true;
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
		if(calcularDescuentoDia(diaDescuento, porcentajeDescuento) >= calcularDescuentoEfectivo(porcentajeDescuentoEfectivo))
			{
			descuento += calcularDescuentoDia(diaDescuento, porcentajeDescuento);
		}else {
			descuento += calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
		}
		this.setDescuento(descuento);
	}
	
	public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuento) {
		
		double descuento = 0;
		
		if(diaDescuento == this.fecha.getDayOfWeek().getValue()) {
			for(ItemCarrito i: this.lstItemCarrito) {
				if(i.getCantidad()>1) {
					descuento+= ((i.getArticulo().getPrecio())*(i.getCantidad()/2))*(porcentajeDescuento/100);
				}
			}
		}		
		return descuento;
	}
	
	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		return this.calcularTotalCarrito()*(porcentajeDescuentoEfectivo/100);
	}
	
	public double totalAPagarCarrito() {
		return calcularTotalCarrito() - descuento;
	}
	
	public LocalTime traerHoraRetiro(LocalDate fecha) {
		LocalTime hora = null;
			if(entrega instanceof RetiroLocal) {
				RetiroLocal retiro = (RetiroLocal)entrega;
				if(retiro.getFecha().isEqual(fecha)) hora = retiro.getHoraEntrega();
			}
			return hora;
	}
	
	@Override
	public String toString() {
		return "id " + id + " fecha: " + fecha + " hora: " + hora + " cerrado: " + cerrado + " descuento: "
				+ descuento + " cliente: " + cliente;
	}

	public void imprimirListadoItems(){
		System.out.println("ID\tART.\tPRECIO\tCODIGO\t\t\tCANTIDAD\tSUBTOTAL");
		for(ItemCarrito i: this.lstItemCarrito){
			System.out.println(i.toString());
		}
	}

	public void mostrarTicket() {
		System.out.println("El Carrito es el numero: " + this.getId());
		this.imprimirListadoItems();
		System.out.println("Este es el descuento del precio total: $"+ this.getDescuento() + "\nEste es el total: $" + this.totalAPagarCarrito());
	}

}

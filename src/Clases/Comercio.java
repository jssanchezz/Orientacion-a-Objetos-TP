package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Comercio extends Actor{
	
	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private List<DiaRetiro> lstDiaRetiro;
	private List<Articulo> lstArticulo;
	private List<Carrito> lstCarrito;
	
	//Constructor
	
	public Comercio(int id, String nombreComercio, String email, String celular, long cuit, int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception{
		super(id, new Contacto(email,celular));
		this.nombreComercio = nombreComercio;
		setCuit(cuit);
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.costoFijo = 0;
		this.costoPorKm = 0;
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstArticulo = new ArrayList<Articulo>();
		this.lstCarrito = new ArrayList<Carrito>();
	}
	
	public Comercio(int id, String nombreComercio, String email, String celular,long cuit, double costoFijo, double costoPorKm, int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
		this(id,nombreComercio,email,celular,cuit,diaDescuento,porcentajeDescuentoDia,porcentajeDescuentoEfectivo);
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;		
	}
	
	
	//Getters y setters

	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) throws Exception {
		boolean valido = validarIdentificadorUnico(cuit);
		if (valido) {
			this.cuit = cuit;
		}else {
			throw new Exception ("CUIT no valido");
		}
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	public double getCostoPorKm() {
		return costoPorKm;
	}

	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}

	public int getDiaDescuento() {
		return diaDescuento;
	}

	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}

	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}

	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}

	public int getPorcentajeDescuentoEfectivo() {
		return porcentajeDescuentoEfectivo;
	}

	public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}

	public List<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}

	public void setLstDiaRetiro(List<DiaRetiro> lstDiaRetiro) {
		this.lstDiaRetiro = lstDiaRetiro;
	}

	public List<Articulo> getLstArticulo() {
		return lstArticulo;
	}

	public void setLstArticulo(List<Articulo> lstArticulo) {
		this.lstArticulo = lstArticulo;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}	
	
	//Metodos de clase
	
	public boolean agregarArticulo(String nombre, String codBarras, double precio) throws Exception{
		if(traerArticulo(codBarras) != null) {
			throw new Exception ("Articulo existente.");
		}
		int id = 1;
		if(this.getLstArticulo().size()>0) {
			id = (this.getLstArticulo().get(this.getLstArticulo().size()-1).getId()+1);
		}
		return this.getLstArticulo().add(new Articulo(id, nombre, codBarras, precio));
	}
	
	public boolean eliminarArticulo(int id) throws Exception {
		Articulo aux = traerArticulo(id);
		if(aux!=null) {
			throw new Exception ("Articulo inexistente");
		}
		return this.lstArticulo.remove(aux);
	}


	private Articulo traerArticulo(String codBarras) {		
		
		Articulo articulo = null;
		int i = 0;		
		while(articulo == null && i < this.lstArticulo.size() ) {
			if(this.lstArticulo.get(i).getCodBarras() == codBarras) {
				articulo = this.lstArticulo.get(i);
			}
			i++;
		}
		return articulo;
	}
	
	public Articulo traerArticulo(int id) {
		Articulo articulo = null;
		int i = 0;		
		while(articulo == null && i < this.lstArticulo.size() ) {
			if(this.lstArticulo.get(i).getId() == id) {
				articulo = this.lstArticulo.get(i);
			}
			i++;
		}
		return articulo;
	}
	
		
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente,Entrega entrega) throws Exception {
		
		if(traerCarrito(cliente)!=null) {
			throw new Exception ("El cliente posee carrito abierto.");
		}		
		int id = 1;
		if(this.lstCarrito.size()>0) {
			id = this.lstCarrito.get(this.lstCarrito.size()-1).getId()+1;
		}
		return this.lstCarrito.add(new Carrito(id, fecha, hora, cliente, entrega));
	}
	
	
	public boolean eliminarCarrito(int id) throws Exception{	
		Carrito aux = traerCarrito(id);
		if(aux==null) {
			throw new Exception ("No existe el carrito.");
		}
		return this.lstCarrito.remove(aux);
	}
	
	public Carrito traerCarrito(int id) {
		Carrito carrito = null;
		int i = 0;
		while(carrito==null && i<this.lstCarrito.size()) {
			if(this.lstCarrito.get(i).getId()==id) {
				carrito = this.lstCarrito.get(i);
			}
			i++;
		}
		return carrito;
	}
	
	public Carrito traerCarrito(Cliente cliente) {
		Carrito carrito = null;
		int i = 0;
		while(carrito==null && i<this.lstCarrito.size()) {
			if(this.lstCarrito.get(i).getCliente().equals(cliente) && !this.lstCarrito.get(i).isCerrado()) {
				carrito = this.lstCarrito.get(i);
			}
			i++;
		}
		return carrito;
	}
	
	public void cobrarCarrito(int idCarrito) throws Exception {
		Carrito carrito = traerCarrito(idCarrito);
		if(carrito==null) throw new Exception("No existe carrito.");
		cobrarCarrito(traerCarrito(idCarrito).getCliente());
	}
	
	
	public void cobrarCarrito(Cliente cliente) throws Exception{
		
		Carrito carrito = traerCarrito(cliente);
		
		if(carrito==null) throw new Exception("No existe el carrito/Esta cerrado.");
		if(carrito.getLstItemCarrito().size()==0) throw new Exception ("El carrito esta vacio.");
		
		
		carrito.setCerrado(true);
		carrito.calcularDescuentoCarrito(diaDescuento, porcentajeDescuentoDia,porcentajeDescuentoEfectivo);
	}
		
	
	public boolean validarIdentificadorUnico(long cuit) {
		boolean valido = false;
		long digito=0;
		long multiplicar=2;
		long suma=0;
		long dgvalidador=0;
		if (cuit <= 99999999999L) {
			dgvalidador=cuit % 10;    
			cuit=cuit/10;
			for (int i=1; i<=10; i++) {
				digito=cuit % 10;
				suma=suma+(digito*multiplicar);
				cuit=cuit/10;  
				multiplicar++;
				if (multiplicar==8) {
					multiplicar=2;
				}
			}
			suma = 11-(suma%11);
			if (dgvalidador==suma){
				valido = true;
			}
                  
		}
		return valido;
	}
	
	
	public List<LocalTime> multiplestraerHoraRetiro(LocalDate fecha) {
		List<LocalTime> horas = new ArrayList<LocalTime>();
		int i = 0;
		while(i<this.lstCarrito.size()) {
			horas.add(this.lstCarrito.get(i).traerHoraRetiro(fecha));
			i++;
			}
		return horas;
	}
	
	
	public List<Turno> generarTurnosLibres(LocalDate fecha){
		List<Turno> Turnos = new ArrayList<Turno>();
		List<LocalTime> horas = multiplestraerHoraRetiro(fecha);
				for(LocalTime i = LocalTime.of(12, 00);i.isBefore(LocalTime.of(20, 15));i = i.plusMinutes(15L)){
						Turnos.add(new Turno(fecha,i,false));					
				}
		return Turnos;
	}
	
	public List<Turno> generarTurnosOcupados(LocalDate fecha){
		List<Turno> Turnos = generarTurnosLibres(fecha);
		List<LocalTime> horas = multiplestraerHoraRetiro(fecha);
		for(Turno t: Turnos) {
			for(LocalTime h : horas) {
				if(t.getHora().equals(h)) {
					t.setOcupado(true);
				}
				
			}
		}
		return Turnos;
	}

	@Override
	public String toString() {
		return "\tComercio \nNombre del comercio: " + nombreComercio + " \ncuit: " + cuit + " \nDescuento del dia: " + diaDescuento + " \nporcentajeDescuentoDia: "
				+ porcentajeDescuentoDia + " \nporcentajeDescuentoEfectivo: " + porcentajeDescuentoEfectivo ;
	}

	public void imprimirArticulos(){
		System.out.println("ID\tNOMBRE\tPRECIO\tCODIGO");
		for(Articulo a: this.lstArticulo){
			System.out.println(a.toString());
		}
	}

	public void imprimirCarritos(){
		System.out.println("\t\t\t\t\t\tCARRITOS");
		for(Carrito c: this.lstCarrito){
			System.out.println(c.toString());
		}
	}
}

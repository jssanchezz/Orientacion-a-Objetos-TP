package Clases;

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
	
	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm, int diaDescuento,
			int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
		super(id, contacto);
		this.nombreComercio = nombreComercio;
		setCuit(cuit);
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstArticulo = new ArrayList<Articulo>();
		this.lstCarrito = new ArrayList<Carrito>();		
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
	
	public boolean agregarArticulo(Articulo articulo) throws Exception{
		
		if(!existeArticulo(articulo)) {
			//Si la lista esta vacia, setea id del articulo como 1
			if(this.getLstArticulo().isEmpty()) {
				articulo.setId(1);
			}
			else { //Sino toma el id del ultimo articulo de la lista y le suma 1
				articulo.setId(this.getLstArticulo().get(this.getLstArticulo().size()-1).getId()+1);
			}
			this.getLstArticulo().add(articulo);
			return true;
		}
		else {
			throw new Exception ("Articulo existente.");
		}
	}
	
	public boolean eliminarArticulo(Articulo articulo) {
		
		if(!existeArticulo(articulo)) {
			this.getLstArticulo().remove(articulo);
			return true;
		}
		return false;
	}
	
	private boolean existeArticulo(Articulo articulo) {
		
		for(Articulo a: this.getLstArticulo()) {
			if(a.equals(articulo)) {
				return true; //Poner un return aca es legal?
			}
		}
		return false;
	}
	
	private boolean existeCarrito(Carrito carrito) {
		
		for(Carrito c: this.getLstCarrito()) {
			if(carrito.getId() == c.getId()) {
				return true; //Poner un return aca es legal?
			}
		}
		return false;
	}
	
	
	public boolean agregarCarrito(Carrito carrito) {
		
		if(!existeCarrito(carrito)) {
			this.getLstCarrito().add(carrito);
			return true;
		}
		
		return false;
	}
	
	//Se puede sobrecargar este metodo, y que elimine por id--
	public boolean eliminarCarrito(Carrito carrito) {
		
		if(!existeCarrito(carrito)) {
			this.getLstCarrito().remove(carrito);
			return true;
		}
		
		return false;
	}
	
	public boolean agregarDiaRetiro(DiaRetiro dia) {
		
		if(!existeDiaRetiro(dia)) {
			this.getLstDiaRetiro().add(dia);
			return true;
		}
		
		return false;
	
	}
	
	public boolean eliminarDiaRetiro(DiaRetiro dia) {
		
		if(!existeDiaRetiro(dia)) {
			this.getLstDiaRetiro().remove(dia);
			return true;
		}
		
		return false;
	
	}
	
	private boolean existeDiaRetiro(DiaRetiro dia) {
		
		for(DiaRetiro d: this.getLstDiaRetiro()) {
			if(dia.getId() == d.getId()) {
				return true; //Poner un return aca es legal?
			}
		}
		return false;
	}
	
	public boolean validarIdentificadorUnico(long cuit) {
		boolean valido = true;
		
		return valido;
	}

}

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
	
	public void agregarArticulo(Articulo articulo) throws Exception{
		
		if(!existeArticulo(articulo)) {
			//Si la lista esta vacia, setea id del articulo como 1
			if(this.getLstArticulo().isEmpty()) {
				articulo.setId(1);
			}
			else { //Sino toma el id del ultimo articulo de la lista y le suma 1
				articulo.setId(this.getLstArticulo().get(this.getLstArticulo().size()-1).getId()+1);
			}
			this.getLstArticulo().add(articulo);
		}
		else {
			throw new Exception ("Articulo existente.");
		}
	}
	
	public void eliminarArticulo(Articulo articulo) throws Exception {
		
		if(!existeArticulo(articulo)) {
			this.getLstArticulo().remove(articulo);
		}
		else {
			throw new Exception ("Articulo inexistente.");
		}
	}
	
	private boolean existeArticulo(Articulo articulo) {		
		boolean existe = false;
		for(Articulo a: this.getLstArticulo()) {
			if(a.equals(articulo)) {
				existe = true;
			}
		}
		return existe;
	}
	
	private boolean existeCarrito(Carrito carrito) {
		boolean existe = false;
		for(Carrito c: this.getLstCarrito()) {
			if(c.equals(carrito)) {
				existe = true;
			}
		}
		return existe;
	}
	
	
	public void agregarCarrito(Carrito carrito) throws Exception {
		
		if(!existeCarrito(carrito)) {
			this.getLstCarrito().add(carrito);
		}
		else
		{
			throw new Exception ("Carrito existente/Cliente ya posee carrito.");
		}
	}
	
	
	public void eliminarCarrito(Carrito carrito) throws Exception{
		
		if(!this.lstCarrito.remove(carrito))
			throw new Exception ("El carrito no existe");
		
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
			for (int i=1; i==8; i++) {
				digito=cuit % 10;
				suma=suma+(digito*multiplicar);
				cuit=cuit/10;  
				multiplicar= multiplicar++;
				if (multiplicar==7) {
					multiplicar=2;
				}
			}
			if (cuit==30 && dgvalidador==suma%11){
				valido = true;
			}
                  
		}
		return valido;
	}

}

package Clases;
import java.time.LocalDate;
import java.time.LocalTime;

public class Envio extends Entrega {
	
	private LocalTime horaHasta;
	private LocalTime horaDesde;
	private double costo;
	private Ubicacion ubicacion;
	
	//Constructor
	
	public Envio(int id, LocalDate fecha, boolean efectivo, LocalTime horaDesde, LocalTime horaHasta,
			Ubicacion ubicacion) {
		super(id, fecha, efectivo);
		this.horaHasta = horaHasta;
		this.horaDesde = horaDesde;
		this.costo = 0;
		this.ubicacion = ubicacion;
	}

	//Getters y setters
	
	public LocalTime getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}

	public LocalTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public static double distanCoord(double lat1, double lng1, double lat2, double lng2) {		
		
		double radioTierra = 6371;
	    double dLat = Math.toRadians(lat2 - lat1);
	    double dLng = Math.toRadians(lng2 - lng1);
	    double sindLat = Math.sin(dLat/2);
	    double sindLng = Math.sin(dLng/2);
	    double va1 = Math.pow(sindLat, 2)+Math.pow(sindLng, 2)*Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2));
	    double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
	    
	    return radioTierra * va2;
	}
	
	public void calcularCostoEnvio(double lat1, double lng1, double costoFijo, double costoPorKm) {		
		double costoTotal = 0;
		double distancia = Envio.distanCoord(lat1,lng1,this.ubicacion.getLatitud(),this.ubicacion.getLongitud());
		distancia = Math.round(distancia*100)/100.0d;
		costoTotal = costoFijo + (distancia*costoPorKm);
		this.setCosto(costoTotal);
	}
	
}

package Clases;

public class Contacto {

	private String email;
	private String celular;
	private Ubicacion ubicacion;
	
	//Constructor
	
	public Contacto(String email, String celular, Ubicacion ubicacion) {
		this.email = email;
		this.celular = celular;
		this.ubicacion = ubicacion;
	}	
	
	//Getters y setters
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
}


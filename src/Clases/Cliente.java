package Clases;

public class Cliente extends Actor {

	//Atributos
	
	private String apellido;
	private String nombres;
	private long dni;

	//Constructor
	
	public Cliente(int id, Contacto contacto, String apellido, String nombres, long dni) throws Exception {
	super(id, contacto);
	this.apellido = apellido;
	this.nombres = nombres;
	setDni(dni);
	}

	public String getApellido() {
		return apellido;
	}

	// Cualquier comprobacion de datos deberian pasar por los "Setters"
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) throws Exception {
		boolean valido = validarIdentificadorUnico(dni);
		if (valido) {
			this.dni = dni;
		}else {
			throw new Exception ("DNI no valido");
		}
	}

	public String traerNombreCompleto() {
		String resultado;
		resultado = nombres + " " + apellido;
		return resultado;
	}
	
	public boolean validarIdentificadorUnico(long dni) {
		boolean valido = false;
		if (this.dni>999999 && this.dni<1000000) {
			valido = true;
		}
		return valido;
	}
}

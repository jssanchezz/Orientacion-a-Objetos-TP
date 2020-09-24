package Clases;

//Editado

public class Cliente extends Actor {

	//Atributos
	
	private String apellido;
	private String nombres;
	private int dni;

	//Constructor
	
	public Cliente(int id, Contacto contacto, String apellido, String nombres, int dni) {
		super(id, contacto);
	this.apellido = apellido;
	this.nombres = nombres;
	this.dni = dni;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String traerNombreCompleto() {
		String resultado;
		resultado = nombres + " " + apellido;
		return resultado;
	}
}

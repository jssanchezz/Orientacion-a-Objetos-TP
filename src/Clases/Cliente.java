package Clases;

public class Cliente extends Actor {

	//Atributos
	
	private String apellido;
	private String nombres;
	private long dni;

	//Constructor
	
	public Cliente(int id, String apellido, String nombres, String email, String celular, long dni, Ubicacion ubicacion) throws Exception {
		super(id, new Contacto(email,celular,ubicacion));
		this.apellido = apellido;
		this.nombres = nombres;
		setDni(dni);
	}

	public String getApellido() {
		return apellido;
	}

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
		if (dni>9999999 && dni<99999999) {
			valido = true;
		}
		return valido;
	}

	
	public boolean equals(Cliente cliente) {
		if(this.dni == cliente.dni) {
			return true;
		}
		return false;
			
	}

	@Override
	public String toString() {
		return "apellido: " + apellido + ", nombres: " + nombres + ", dni: " + dni;
	}
	
}

package Clases;

public abstract class Actor {

	protected int id;
	protected Contacto contacto;
	
	//Constructor
	
	protected Actor(int id, Contacto contacto) {
		this.id = id;
		this.contacto = contacto;
	}
	
	//Getters y setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	//FIRMA METODO SIN IMPLEMENTAR
	
	protected abstract boolean validarIdentificadorUnico (long identificador);
}

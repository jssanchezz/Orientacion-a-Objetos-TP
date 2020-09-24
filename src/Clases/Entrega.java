package Clases;

import java.time.LocalDate;

public abstract class Entrega {
	
	protected int id;
	protected LocalDate fecha;
	protected boolean efectivo;	
	
	//Constructor
	
	protected Entrega(int id, LocalDate fecha, boolean efectivo) {
		this.id = id;
		this.fecha = fecha;
		this.efectivo = efectivo;
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

	public boolean isEfectivo() {
		return efectivo;
	}

	public void setEfectivo(boolean efectivo) {
		this.efectivo = efectivo;
	}
	
}

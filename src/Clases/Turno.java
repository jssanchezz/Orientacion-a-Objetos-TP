package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Turno {
	private LocalDate dia;
	private LocalTime hora;
	private boolean ocupado;

	public Turno(LocalDate dia, LocalTime hora, boolean ocupado) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.ocupado = ocupado;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public String toString() {
		return "Turnos de la fecha: " + dia + ", hora: " + hora + ", El turno esta ocupado? " + ocupado;
	}
	
}

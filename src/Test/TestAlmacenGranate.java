package Test;

import Clases.Articulo;
import Clases.Carrito;
import Clases.Cliente;
import Clases.Comercio;
import Clases.Contacto;
import Clases.DiaRetiro;
import Clases.Entrega;
import Clases.Envio;
import Clases.RetiroLocal;
import Clases.Turno;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class TestAlmacenGranate {

	public static void main(String[] args) {
	
		Comercio miComercio = null;
		Entrega retiro = new RetiroLocal(3, LocalDate.of(2020, 10, 11), true, LocalTime.of(12, 30));
		Entrega retiro1 = new RetiroLocal(3, LocalDate.of(2020, 10, 11), true, LocalTime.of(12, 45));
		Entrega retiro2 = new RetiroLocal(3, LocalDate.of(2020, 10, 11), true, LocalTime.of(13, 30));
		List<Turno> Turnos = new ArrayList<Turno>();
		List<LocalTime> Horas = new ArrayList<LocalTime>();

		// CASO DE USO: CREAR COMERCIO -> Se crea miComercio correctamente, miComercio 2
		// contiene cuit invalido y lanza excepcion
		System.out.println("--->Escenario 1.A: Se crea el Comercio<---");
		try {
			miComercio = new Comercio(2, "Super Pepe", "@gmail.com", "1122554466", 30610252334l, 2, 6, 25);
			Comercio miComercio2 = new Comercio(2, "Invalida", "@gmail.com", "1234567890", 33123456l, 2, 6, 25);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(miComercio.toString());
		System.out.println("--->Fin del caso de uso:Crear comercio<---\n");

		// CASO DE USO: CREAR ARTICULOS

		// Se agrega al comercio un articulo valido
		System.out.println("--->Escenario 2.A: Se Agrega unos articulos al Comercio<---");
		try {
			miComercio.agregarArticulo("Taza", "6937733560324", 45);
			miComercio.agregarArticulo("Knorr", "7794000597518", 60);
			miComercio.agregarArticulo("Aceite", "7794770105159", 80);
			miComercio.agregarArticulo("Dolce", "7790742142603", 120);
			miComercio.agregarArticulo("Pate", "7790360720115", 50);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.imprimirArticulos();

		// No agrega el articulo porque ya existe uno con el mismo codigo de barras
		try {
			System.out.println("--->Escenario 2.B: Se intenta agregar un articulo ya existente al comercio<---");
			miComercio.agregarArticulo("Lapicera", "6937733560324", 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// No agrega por codigo invalido
		try {
			System.out.println(
					"--->Escenario 2.C: Se intenta agregar un articulo que posee un codigo de barras invalido<---");
			miComercio.agregarArticulo("Nutella", "27898024394181", 340);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Agregamos un nuevo articulo y verificamos el incremento del id
		try {
			System.out.println("--->Escenario 2.D: Se agrega un nuevo articulo<---");
			miComercio.agregarArticulo("Bic", "6921734966469", 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.imprimirArticulos();
		System.out.println("--->Fin del caso de uso:Crear articulos<---\n");
		// CASO DE USO: Crear cliente -> Se crea el Cliente juan (parametros validos), y
		// el cliente pedro contiene dni invalido y lanza excepcion
		Cliente juan = null;
		Cliente rolando = null;

		try {
			System.out.println(
					"--->Escenario 3.A: Se crea un cliente con datos validos[Juan] y otros con datos invalidos[Pedro]<---");
			juan = new Cliente(3, "Sanchez", "Juan", "@gmail.com", "1111111111", 38355972l);
			rolando = new Cliente(4, "Rapali", "Rolando", "@gmail.com", "1111111111", 17252301l);
			Cliente pedro = new Cliente(1, "Gomez", "Pedro", "@gmail.com", "1111111111", 1234l);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("--->Fin del caso de uso:Crear cliente<---\n");
		// CASO DE USO: AGREGAR CARRITO

		// Agrega el primero y el segundo no ya que pertenece al mismo cliente y el
		// carrito esta abierto
		try {
			System.out.println(
					"--->Escenario 4.A: Se intenta agregar un carrito nuevo a un cliente que tiene un carrito abierto<---");
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), juan, retiro);
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), rolando, retiro2);
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), juan, retiro);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.imprimirCarritos();

		miComercio.traerCarrito(1).setCerrado(true);

		// Al cerrar un carrito del cliente, permite volver a crear otro para el mismo
		// cliente
		try {
			System.out.println(
					"--->Escenario 4.B: Crea un nuevo carrito para el cliente una vez que este cierra el que tiene<---");
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), juan, retiro1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.imprimirCarritos();

		// Agregamos el articulo con id 1 al carrito (si se pasa un id que no existe,
		// lanza excepcion de articulo invalido)
		try {
			System.out.println("--->Escenario 4.C: Se intenta agregar un articulo a un carrito cerrado<---");
			miComercio.traerCarrito(1).agregar(miComercio.traerArticulo(1), 3);// No agrega ya que el carrito esta
																				// cerrado
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("--->Escenario 4.D: Se agrega un articulo con id del carrito<---");
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(1), 3);
			miComercio.traerCarrito(2).imprimirListadoItems();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--->Fin del caso de uso:Agregar al Carrito<---\n");
		// Sacamos una cantidad menor a la total
		try {
			System.out.println("--->Escenario 5.A: Se saca 2 unidades de un articulo<---");
			miComercio.traerCarrito(2).sacar(miComercio.traerArticulo(1), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.traerCarrito(2).imprimirListadoItems();

		// Sacamos unidades restantes
		try {
			System.out.println("--->Escenario 5.B: Se sacan las unidades restantes de un articulo en un carrito<---");
			miComercio.traerCarrito(2).sacar(miComercio.traerArticulo(1), 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.traerCarrito(2).imprimirListadoItems();

		// Intentamos sacar un articulo que ya no existe
		try {
			System.out.println(
					"--->Escenario 5.C: Intentamos sacar unidades de un articulo que no existe en el carrito<---");
			miComercio.traerCarrito(2).sacar(miComercio.traerArticulo(1), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--->Fin del caso de uso:Sacar del Carrito<---\n");
		// CASO DE USO: CERRAR CARRITO

		try {
			System.out.println(
					"--->Escenario 6.A: Se realiza el cierre del carrito y se pasa a facturar el precio total<---");
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(1), 3);
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(2), 6);
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(3), 1);
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(4), 1);
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(5), 2);
			miComercio.cobrarCarrito(2);
			miComercio.imprimirCarritos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Probamos el ticket
		try {
			System.out.println(
					"--->Escenario 6.B: Se imprime el ticket total de la compra con los descuentos aplicados<---");
			miComercio.traerCarrito(2).mostrarTicket();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// El carrito ya esta cerrado, lanza excepcion
		try {
			System.out.println("--->Escenario 6.C: Se intenta cobrar otra vez a alguien que ya ha sido cobrado<---");
			miComercio.cobrarCarrito(juan);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--->Fin del caso de uso:Cerrar carrito<---");
		try {
			Horas = miComercio.multiplestraerHoraRetiro(LocalDate.of(2020, 10, 11));
			System.out.println("--------");
			for (LocalTime h : Horas) {
				System.out.println("--" + h);
			}
			System.out.println("--------");
			Turnos = miComercio.generarTurnosOcupados(LocalDate.of(2020, 10, 11));
			for (Turno t : Turnos) {
				System.out.println("--" + t);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

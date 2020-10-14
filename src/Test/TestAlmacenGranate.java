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
import Clases.Ubicacion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class TestAlmacenGranate {

	public static void main(String[] args) {
	
		Comercio miComercio = null;
		
		

		// CASO DE USO: CREAR COMERCIO -> Se crea miComercio correctamente, miComercio 2
		// contiene cuit invalido y lanza excepcion
		System.out.println("--->Escenario 1.A: Se crea el Comercio<---");
		try {
			miComercio = new Comercio(2, "Super Pepe", "@gmail.com", "1122554466", 30610252334l, 200, 53, 7, 15, 25, new Ubicacion(-34.736039, -58.391270));
			Comercio miComercio2 = new Comercio(2, "Invalida", "@gmail.com", "1234567890", 33123456l, 300, 23, 2, 6, 25,new Ubicacion(34.79, 58.37));
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
		Cliente rocio = null;

		try {
			System.out.println(
					"--->Escenario 3.A: Se crea un cliente con datos validos[Juan] y otros con datos invalidos[Pedro]<---");
			juan = new Cliente(3, "Sanchez", "Juan", "@gmail.com", "1111111111", 37608935l, new Ubicacion(-34.800499, -58.388777));
			rolando = new Cliente(4, "Rapali", "Rolando", "@gmail.com", "1111111111", 38355972l, new Ubicacion(-34.80, 12.87));
			rocio = new Cliente(5, "Trinidad", "Rocio", "@gmail.com", "1111111111", 40291447l, new Ubicacion(-40.5, 10.5));
			Cliente pedro = new Cliente(1, "Gomez", "Pedro", "@gmail.com", "1111111111", 1234l, new Ubicacion(-34.80, 12.87));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Entrega envioPaCasa = new Envio(3, LocalDate.of(2020, 10, 11), true, LocalTime.of(12, 30), LocalTime.of(13, 00), null);
		Entrega retiro1 = new RetiroLocal(3, LocalDate.of(2020, 10, 11), true, LocalTime.of(12, 45));
		Entrega retiro2 = new RetiroLocal(3, LocalDate.of(2020, 10, 11), false, LocalTime.of(13, 30));
		((Envio)envioPaCasa).setUbicacion(juan.getContacto().getUbicacion());
	

		System.out.println("--->Fin del caso de uso:Crear cliente<---\n");
		// CASO DE USO: AGREGAR CARRITO

		// Agrega el primero y el segundo no ya que pertenece al mismo cliente y el
		// carrito esta abierto
		try {
			System.out.println(
					"--->Escenario 4.A: Se intenta agregar un carrito nuevo a un cliente que tiene un carrito abierto<---");
			miComercio.agregarCarrito(LocalDate.of(2020, 10, 11), LocalTime.now(), juan, envioPaCasa);
			miComercio.agregarCarrito(LocalDate.of(2020, 10, 11), LocalTime.now(), rolando, retiro1);
			miComercio.agregarCarrito(LocalDate.of(2020, 10, 11), LocalTime.now(), rocio, retiro2);
			miComercio.agregarCarrito(LocalDate.of(2020, 10, 11), LocalTime.now(), juan, envioPaCasa);
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
			miComercio.agregarCarrito(LocalDate.of(2020, 10, 11), LocalTime.now(), juan, envioPaCasa);
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
			System.out.println("--->Se cargan los carritos<---");
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(1), 3);
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(2), 6);
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(3), 1);
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(4), 1);
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(5), 2);
			
			miComercio.traerCarrito(3).agregar(miComercio.traerArticulo(1), 3);
			miComercio.traerCarrito(3).agregar(miComercio.traerArticulo(2), 6);
			miComercio.traerCarrito(3).agregar(miComercio.traerArticulo(3), 1);
			miComercio.traerCarrito(3).agregar(miComercio.traerArticulo(4), 1);
			miComercio.traerCarrito(3).agregar(miComercio.traerArticulo(5), 2);
			
			miComercio.traerCarrito(4).agregar(miComercio.traerArticulo(1), 4);
			miComercio.traerCarrito(4).agregar(miComercio.traerArticulo(2), 2);
			miComercio.traerCarrito(4).agregar(miComercio.traerArticulo(3), 3);
			miComercio.traerCarrito(4).agregar(miComercio.traerArticulo(4), 2);
			miComercio.traerCarrito(4).agregar(miComercio.traerArticulo(5), 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(
					"--->Escenario 6.A: Se realiza el cierre del carrito y se pasa a facturar el precio total<---");
			miComercio.cobrarCarrito(2);
			miComercio.cobrarCarrito(3);
			miComercio.cobrarCarrito(4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.imprimirCarritos();
		// Probamos el ticket
		try {
			System.out.println("--->Escenario 6.B.1: Se imprime el ticket total de la compra de (Rocio) con los descuentos aplicados -Siendo mayor el descuento aplicado por dia- <---");
			miComercio.traerCarrito(2).mostrarTicket();
			System.out.println("--->Escenario 6.B.2: Se imprime el ticket total de la compra de (Rolando) con los descuentos aplicados -Siendo mayor el descuento aplicado por efectivo- <---");
			miComercio.traerCarrito(3).mostrarTicket();
			System.out.println("--->Escenario 6.B.3: Se imprime el ticket total de la compra de (Juan) con los descuentos aplicados y un envio <---");
			miComercio.traerCarrito(4).mostrarTicket();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.getLstDiaRetiro().add(new DiaRetiro(0,7,LocalTime.of(10, 00), LocalTime.of(15, 00),15));
		// El carrito ya esta cerrado, lanza excepcion
		System.out.println("--->Escenario 6.C: Se intenta cobrar otra vez a alguien que ya ha sido cobrado<---");
		try {
			miComercio.cobrarCarrito(juan);
			
			miComercio.cobrarCarrito(rolando);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--->Fin del caso de uso:Cerrar carrito<---\n");
		
		List<Turno> Turnos = new ArrayList<Turno>();

		// CASO DE USO: Generar agenda
		try {
			System.out.println("--->Escenario 7.A:Se genera una agenda con los turnos en el dia de retiro actual<---");
			Turnos = miComercio.generarAgenda(LocalDate.of(2020, 10, 11));
			for (Turno t : Turnos) {
				System.out.println(t);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--->Fin del caso de uso:Generar agenda<---\n");	
	}
}

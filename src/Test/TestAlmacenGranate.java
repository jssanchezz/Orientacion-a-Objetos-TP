package Test;

import Clases.Articulo;
import Clases.Carrito;
import Clases.Cliente;
import Clases.Comercio;
import Clases.Turno;
import Clases.Contacto;
import Clases.DiaRetiro;
import Clases.Entrega;
import Clases.ItemCarrito;
import Clases.RetiroLocal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;



public class TestAlmacenGranate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Contacto contacto1 = new Contacto("Felipe@gmail.com", "1164358765", null);
			// -------------------------------------------------------------
			// Se Aniade un nuevo articulo:
			// -------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Nuevo Articulo con [codigo de barras = 7898024394181]<----");
				System.out.print("\n");
				Articulo articulo1 = new Articulo("Nutella", "7898024394181", 140.5);
				System.out.println(articulo1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: Nuevo Articulo con [codigo de barras = 4564128481231]<----");
				System.out.print("\n");
				Articulo articulo1 = new Articulo("Nutella", "4564128481231", 140.5);
				System.out.println(articulo1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println("\n\t---------Fin del caso de uso para crear un articulo---------");
			}
			Articulo articulo1 = new Articulo("Nutella", "7898024394181", 140.5);
			Articulo articulo2 = new Articulo("Sabonis sabor", "6937733560324", 5.25);
			ItemCarrito itemCarrito1 = new ItemCarrito(articulo1, 1);
			// -------------------------------------------------------------
			// Se Aniade un nuevo Cliente:
			// -------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Nuevo Cliente con [dni = 22354125]<----");
				System.out.print("\n");
				Cliente cliente1 = new Cliente(2, null, "Fernando", "Lopez", 22354125l);
				System.out.println(cliente1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: Nuevo Cliente con [dni = 535412]<----");
				System.out.print("\n");
				Cliente cliente1 = new Cliente(2, contacto1, "Fernando", "Lopez", 535412l);
				System.out.println(cliente1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println("\n\t---------Fin del caso de uso para crear un cliente---------");
			}
			Cliente cliente1 = new Cliente(2, contacto1, "Fernando", "Lopez", 22354125l);
			// -------------------------------------------------------------
			// Se saca items del carrito:
			// -------------------------------------------------------------
			Carrito carrito1 = new Carrito(LocalDate.of(2020, 8, 20), LocalTime.of(10, 15), 22.45, cliente1, null);
			// carrito1.agregar(articulo1, 3);
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Sacar Items 1 unidad de un Articulo del carrito<----");
				System.out.print("\n");
				System.out.println(carrito1);/// No elimina los items del carrito
				carrito1.sacar(articulo1, 1);
				System.out.println(carrito1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: Sacar Items 3 unidades de un Articulo del carrito<----");
				System.out.print("\n");
				carrito1.sacar(articulo1, 3);
				System.out.println(carrito1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println("\n\t---------Fin del caso de uso para sacar 1 articulo del carrito---------");
			}
			carrito1.agregar(articulo1, 3);
			// -------------------------------------------------------------
			// Se Añade un nuevo Comercio:
			// -------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Nuevo comercio con [cuit = 30610252334]<----");
				System.out.print("\n");
				Comercio comercio1 = new Comercio(2, contacto1, "Super Pepe", 30610252334l, 22.52, 14.55, 2, 6, 25);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: Nuevo comercio con [cuit = 3012354825]<----");
				System.out.print("\n");
				Comercio comercio1 = new Comercio(2, null, "Super Pedro", 3012354825l, 22.52, 14.55, 2, 6, 25);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println("\n\t---------Fin del caso de uso para crear un nuevo comercio---------");
			}
			Comercio comercio1 = new Comercio(2, contacto1, "Super Pepe", 30610252334l, 22.52, 14.55, 2, 6, 25);
			// -------------------------------------------------------------
			// Se Aniade un nuevo Articulo a la lista de articulos del Comercio:
			// -------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Se agrega un Articulo a la lstArticulo de comercio<----");
				System.out.print("\n");
				comercio1.agregarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println(
						"---->Escenario 2: Se agrega un Articulo a la lstArticulo de comercio que ya existe<----");
				System.out.print("\n");
				comercio1.agregarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println(
						"\n\t---------Fin del caso de uso para agregar un articulo a lstArticulos de comercio---------");
			}
			// comercio1.agregarArticulo(articulo1);
			// -------------------------------------------------------------
			// Se elimina un nuevo Articulo de la lst Articulo de Comercio:
			// -------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Se elimina un Articulo a la lstArticulo de comercio<----");
				System.out.print("\n");
				comercio1.eliminarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println(
						"---->Escenario 2: Se intenta eliminar un Articulo a la lstArticulo de comercio que ya fue eliminado<----");
				System.out.print("\n");
				comercio1.eliminarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println(
						"\n\t---------Fin del caso de uso para eliminar un articulo de lstArticulos de comercio---------");
			}
			// comercio1.eliminarArticulo(articulo2);
			// -------------------------------------------------------------
			// Se agrega un carrito al lstcarrito de Comercio:
			// -------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Se agrega un carrito a la lstCarrito de comercio<----");
				System.out.print("\n");
				comercio1.agregarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println(
						"---->Escenario 2: Se agrega un carrito a la lstCarrito de comercio que ya existe<----");
				System.out.print("\n");
				comercio1.agregarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println(
						"\n\t---------Fin del caso de uso para agregar un carrito a lstCarrito de comercio---------");
			}
			// -------------------------------------------------------------
			// Se elimina un carrito al lstcarrito de Comercio:
			// -------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Se elimina un carrito a la lstCarrito de comercio<----");
				System.out.print("\n");
				comercio1.eliminarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println(
						"---->Escenario 2: Se elimina un carrito a la lstCarrito de comercio que ya fue eliminado<----");
				System.out.print("\n");
				// comercio1.agregarCarrito(carrito1);
				comercio1.eliminarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println(
						"\n\t---------Fin del caso de uso para eliminar un carrito a lstCarrito de comercio---------");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}

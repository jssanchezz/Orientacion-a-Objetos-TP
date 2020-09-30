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
			//-------------------------------------------------------------
			//Se Añade un nuevo articulo
			//-------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: new Articulo<----");
				System.out.print("\n");
				Articulo articulo1 = new Articulo("Nutella", "7898024394181", 140.5);
				System.out.println(articulo1);
			}
			catch(Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: new Articulo<----");
				System.out.print("\n");
				Articulo articulo1 = new Articulo("Nutella", "78980243941", 140.5);
				System.out.println(articulo1);
			}
			catch(Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			Articulo articulo1 = new Articulo("Nutella", "7898024394181", 140.5);
			Articulo articulo2 = new Articulo("Sabonis sabor", "6937733560324", 5.25);
			ItemCarrito itemCarrito1 = new ItemCarrito(articulo1, 1);
			//-------------------------------------------------------------
			//Se Añade un nuevo Cliente
			//-------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: new Cliente<----");
				System.out.print("\n");
				Cliente cliente1 = new Cliente(2, null,"Fernando", "Lopez", 22354125l);
				System.out.println(cliente1);
			}
			catch(Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: new Cliente<----");
				System.out.print("\n");
				Cliente cliente1 = new Cliente(2, contacto1, "Fernando", "Lopez", 223541l);
				System.out.println(cliente1);
			}
			catch(Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			Cliente cliente1 = new Cliente(2, contacto1,"Fernando", "Lopez", 22354125l);
			//-------------------------------------------------------------
			//Se saca items del carrito
			//-------------------------------------------------------------
			Carrito carrito1 = new Carrito(LocalDate.of(2020, 8, 20), LocalTime.of(10, 15), 22.45, cliente1, null);
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Sacar Items del carrito<----");
				System.out.print("\n");
				carrito1.agregar(articulo1, 3);
				System.out.println(carrito1);
			}
			catch(Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: Sacar Items del carrito<----");
				System.out.print("\n");
				carrito1.sacar(articulo1, 3);
				System.out.println(carrito1);
			}
			catch(Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			carrito1.agregar(articulo1, 3);
			//-------------------------------------------------------------
			//Se Añade un nuevo Comercio
			//-------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: new comercio<----");
				System.out.print("\n");
				Comercio comercio1 = new Comercio(2, contacto1, "Super Pepe", 30610252334l, 22.52, 14.55, 2, 6, 25);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: new comercio<----");
				System.out.print("\n");
				Comercio comercio1 = new Comercio(2, null, "Super Pedro", 3012354825l, 22.52, 14.55, 2, 6, 25);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			Comercio comercio1 = new Comercio(2, contacto1, "Super Pepe", 30610252334l, 22.52, 14.55, 2, 6, 25);
			//-------------------------------------------------------------
			//Se Añade un nuevo Articulo al lst de Comercio
			//-------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Se agrega un Articulo a la lista de comercio<----");
				System.out.print("\n");
				comercio1.agregarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: Se agrega un Articulo a la lista de comercio<----");
				System.out.print("\n");
				comercio1.agregarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				}
			//comercio1.agregarArticulo(articulo1);
			//-------------------------------------------------------------
			//Se elimina un nuevo Articulo al lst Articulo de Comercio
			//-------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Se elimina un Articulo a la lista de comercio<----");
				System.out.print("\n");
				comercio1.eliminarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: Se elimina un Articulo a la lista de comercio<----");
				System.out.print("\n");
				comercio1.eliminarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				}
			//comercio1.eliminarArticulo(articulo2);
			//-------------------------------------------------------------
			//Se agrega un carrito al lst carrito de Comercio
			//-------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Se agrega un carrito a la listaCarrito de comercio<----");
				System.out.print("\n");
				comercio1.agregarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: Se agrega un Articulo l la lista de comercio<----");
				System.out.print("\n");
				comercio1.agregarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				}
			//-------------------------------------------------------------
			//Se elimina un carrito al lst carrito de Comercio
			//-------------------------------------------------------------
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 1: Se elimina un carrito a la listaCarrito de comercio<----");
				System.out.print("\n");
				comercio1.eliminarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				}
			try {
				System.out.print("\n");
				System.out.println("---->Escenario 2: Se elimina un carrito a la listaCarrito de comercio<----");
				System.out.print("\n");
				//comercio1.agregarCarrito(carrito1);
				comercio1.eliminarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				}
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}

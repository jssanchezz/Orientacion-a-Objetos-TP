package Test;

import Clases.Articulo;
import Clases.Carrito;
import Clases.Cliente;
import Clases.Comercio;
import Clases.Contacto;

import java.time.LocalDate;
import java.time.LocalTime;


public class TestAlmacenGranate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contacto contacto1 = new Contacto("Felipe@gmail.com", "1164358765", null);
		
		Comercio miComercio = null;
		
		try {
			miComercio = new Comercio(2, contacto1, "Super Pepe", 30610252334l, 22.52, 14.55, 2, 6, 25);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(miComercio.toString());

		//Lo agrega
		try {
			miComercio.agregarArticulo("Lapicera", "6937733560324", 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//No agrega porque repite
		try {
			miComercio.agregarArticulo("Lapicera", "6937733560324", 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//No agrega por codigo invalido
		try {
			miComercio.agregarArticulo("Nutella", "27898024394181", 340);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//Agrega y verificamos el incremento del id
		try {
			miComercio.agregarArticulo("Bic", "6921734966469", 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		
		//Creamos el cliente para el carrito, hay que ver bien si lo instanciamos aca o donde
		Cliente juan = null; 
		try {
			juan = new Cliente(1, null, "Juan", "Sanchez", 37608935);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Agrega el primero y el segundo no ya que pertenece al mismo cliente y el carrito esta abierto
		try {
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), juan);
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), juan);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		miComercio.traerCarrito(1).setCerrado(true);
		
		//Al cerrar un carrito del cliente, permite volver a crear otro para el mismo cliente
		try {
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), juan);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(miComercio.toString());
		
		//Agregamos el articulo con id 1 al carrito (si se pasa un id que no existe, devuelve null pero la clase Carrito no lo agrega)
		miComercio.traerCarrito(1).agregar(miComercio.traerArticulo(1), 3);
		System.out.println(miComercio.traerCarrito(1));
		
		//Sacamos una cantidad menor a la total
		try {
			miComercio.traerCarrito(1).sacar(miComercio.traerArticulo(1), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(miComercio.traerCarrito(1));
		
		//Sacamos unidades restantes
		try {
			miComercio.traerCarrito(1).sacar(miComercio.traerArticulo(1), 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(miComercio.traerCarrito(1));
		
		//Intentamos sacar un articulo que ya no existe
		try {
			miComercio.traerCarrito(1).sacar(miComercio.traerArticulo(1), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(miComercio.traerCarrito(1));
		//Aplicamos descuentos y mostramos el total con el descuento aplicado
		miComercio.traerCarrito(1).agregar(miComercio.traerArticulo(1), 3);
		try {
			System.out.println(miComercio.cobrarCarrito(1));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//Aplicamos descuentos y mostramos el total con el descuento aplicado pero con otro metodo
		try {
			System.out.println("\n-------------------\n");
			System.out.println(miComercio.cobrarCarrito(juan));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//System.out.println(miComercio.traerCarrito(1).totalAPagarCarrito());
		/*try {
			Contacto contacto1 = new Contacto("Felipe@gmail.com", "1164358765", null);
			Comercio comercio1 = null;
			Articulo articulo1 = null;
			Articulo articulo2 = null;
			Cliente cliente1 = null;
			
			//Articulo articulo2 = new Articulo("Sabonis sabor", "6937733560324", 5.25);
			// -------------------------------------------------------------
			// Se crea un nuevo Comercio:
			// -------------------------------------------------------------
			
			System.out.println("\n---->Escenario 1: Nuevo comercio con [cuit = 30610252334]<----\n");
			
			try {
				comercio1 = new Comercio(2, contacto1, "Super Pepe", 30610252334l, 22.52, 14.55, 2, 6, 25);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			System.out.println("\n---->Escenario 2: Nuevo comercio con [cuit = 3012354825]<----\n");
			
			try {
				comercio1 = new Comercio(2, null, "Super Pedro", 3012354825l, 22.52, 14.55, 2, 6, 25);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println("\n\t---------Fin del caso de uso para crear un nuevo comercio---------");
			}
			
			// -------------------------------------------------------------
			// Se agrega un nuevo articulo:
			// -------------------------------------------------------------
			
			System.out.println("\n---->Escenario 1: Nuevo Articulo con [codigo de barras = 7898024394181]<----\n");
			
			try {
				articulo1 = new Articulo("Nutella", "7898024394181", 140.5);
				System.out.println(articulo1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			System.out.println("\n---->Escenario 2: Nuevo Articulo con [codigo de barras = 4564128481231]<----\n");
			
			try {			
				articulo1 = new Articulo("Nutella", "4564128481231", 140.5);
				System.out.println(articulo1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println("\n\t---------Fin del caso de uso para crear un articulo---------");
			}
			
			// -------------------------------------------------------------
			// Se agrega un nuevo Articulo a la lista de articulos del Comercio:
			// -------------------------------------------------------------
			
			System.out.println("\n---->Escenario 1: Se agrega un Articulo a la lstArticulo de comercio<----\n");
			
			try {
				comercio1.agregarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			System.out.println("\n---->Escenario 2: Se agrega un Articulo a la lstArticulo de comercio que ya existe<----\n");
			
			try {
				comercio1.agregarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println(
						"\n\t---------Fin del caso de uso para agregar un articulo a lstArticulos de comercio---------");
			}
			// -------------------------------------------------------------
			// Se agrega un nuevo Cliente:
			// -------------------------------------------------------------
			
			System.out.println("\n---->Escenario 1: Nuevo Cliente con [dni = 22354125]<----\n");
			
			try {
				cliente1 = new Cliente(2, null, "Lopez", "Fernando", 22354125l);
				System.out.println(cliente1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			System.out.println("\n---->Escenario 2: Nuevo Cliente con [dni = 535412]<----\n");
			
			try {				
				cliente1 = new Cliente(2, contacto1, "Fernando", "Lopez", 535412l);
				System.out.println(cliente1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println("\n\t---------Fin del caso de uso para crear un cliente---------");
			}
			// -------------------------------------------------------------
			// Se agrega items al carrito:
			// -------------------------------------------------------------
			
			System.out.println("\n---->Escenario 1: Se agrega 1 item al carrito<----\n");
			
			Carrito carrito1 = new Carrito(LocalDate.of(2020, 8, 20), LocalTime.of(10, 15), 22.45, cliente1, null);
			
			try {
				System.out.println(carrito1);
				carrito1.agregar(articulo1, 3);
				System.out.println(carrito1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println("\n\t---------Fin del caso de uso para sacar 1 articulo del carrito---------");
			}
			// -------------------------------------------------------------
			// Se agrega un carrito al lstcarrito de Comercio:
			// -------------------------------------------------------------
			
			System.out.println("\n---->Escenario 1: Se agrega un carrito a la lstCarrito de comercio<----\n");
			
			try {
				comercio1.agregarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			System.out.println("\n---->Escenario 2: Se agrega un carrito a la lstCarrito de comercio que ya existe<----\n");
			
			try {
				comercio1.agregarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			System.out.println("\n---->Escenario 3: Se agrega un carrito a la lstCarrito de comercio que tiene el carrito cerrado<----\n");
			
			carrito1.setCerrado(true);
			
			try {
				comercio1.agregarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println(
						"\n\t---------Fin del caso de uso para agregar un carrito a lstCarrito de comercio---------");
			}
			// -------------------------------------------------------------
			// Se saca items del carrito:
			// -------------------------------------------------------------
			
			System.out.println("\n---->Escenario 1: Sacar Items 3 unidad de un Articulo del carrito<----\n");
			
			try {
				System.out.println(carrito1);
				carrito1.sacar(articulo1, 3);
				System.out.println(carrito1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			System.out.println("\n---->Escenario 2: Sacar Items 3 unidades de un Articulo del carrito<----\n");
			
			try {
				carrito1.sacar(articulo1, 3);
				System.out.println(carrito1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println("\n\t---------Fin del caso de uso para sacar 1 articulo del carrito---------");
			}
			// -------------------------------------------------------------
			// Se elimina un nuevo Articulo de la lst Articulo de Comercio:
			// -------------------------------------------------------------
			
			System.out.println("\n---->Escenario 1: Se elimina un Articulo a la lstArticulo de comercio<----\n");
			
			try {
				comercio1.eliminarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			System.out.println("\n---->Escenario 2: Se intenta eliminar un Articulo a la lstArticulo del comercio que ya fue eliminado<----\n");
			
			try {
				comercio1.eliminarArticulo(articulo1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			} finally {
				System.out.println(
						"\n\t---------Fin del caso de uso para eliminar un articulo de lstArticulos de comercio---------");
			}
			// -------------------------------------------------------------
			// Se elimina un carrito al lstcarrito de Comercio:
			// -------------------------------------------------------------
			
			System.out.println("\n---->Escenario 1: Se elimina un carrito a la lstCarrito de comercio<----\n");
			
			try {
				comercio1.eliminarCarrito(carrito1);
				comercio1.eliminarCarrito(carrito1);
				System.out.println(comercio1);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			System.out.println("\n---->Escenario 2: Se elimina un carrito a la lstCarrito de comercio que ya fue eliminado<----\n");
			
			try {
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
		}*/
	}

}

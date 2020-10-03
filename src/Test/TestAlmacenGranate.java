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
	
		Comercio miComercio = null;

		//CASO DE USO: CREAR COMERCIO -> Se crea miComercio correctamente, miComercio 2 contiene cuit invalido y lanza excepcion
		System.out.println("--->Escenario 1: Se crea el Comercio<---");
		try {
			miComercio = new Comercio(2,"Super Pepe","@gmail.com","1122554466",30610252334l,2,6,25);
			Comercio miComercio2 = new Comercio(2,"Invalida","@gmail.com","1234567890",33123456l,2,6,25);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(miComercio.toString());

		//CASO DE USO: CREAR ARTICULOS

		//Se agrega al comercio un articulo valido
		System.out.println("--->Escenario 2.A: Se Agrega un articulo al Comercio<---");
		try {
			miComercio.agregarArticulo("Taza", "6937733560324", 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.imprimirArticulos();

		//No agrega el articulo porque ya existe uno con el mismo codigo de barras
		try {
			System.out.println("--->Escenario 2.B: Se intenta agregar un articulo ya existente al comercio<---");
			miComercio.agregarArticulo("Lapicera", "6937733560324", 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//No agrega por codigo invalido
		try {
			System.out.println("--->Escenario 2.C: Se intenta agregar un articulo que posee un codigo de barras invalido<---");
			miComercio.agregarArticulo("Nutella", "27898024394181", 340);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//Agregamos un nuevo articulo y verificamos el incremento del id
		try {
			miComercio.agregarArticulo("Bic", "6921734966469", 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.imprimirArticulos();		
		
		//CASO DE USO: Crear cliente -> Se crea el Cliente juan (parametros validos), y el cliente pedro contiene dni invalido y lanza excepcion
		Cliente juan = null;

		try {
			juan = new Cliente(3,"Sanchez","Juan","@gmail.com","1111111111",38355972l);
			Cliente pedro = new Cliente(1,"Gomez","Pedro","@gmail.com","1111111111",1234l);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//CASO DE USO: AGREGAR CARRITO

		//Agrega el primero y el segundo no ya que pertenece al mismo cliente y el carrito esta abierto
		try {
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), juan);
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), juan);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		miComercio.imprimirCarritos();
		
		miComercio.traerCarrito(1).setCerrado(true);
		
		//Al cerrar un carrito del cliente, permite volver a crear otro para el mismo cliente
		try {
			miComercio.agregarCarrito(LocalDate.now(), LocalTime.now(), juan);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//Agregamos el articulo con id 1 al carrito (si se pasa un id que no existe, lanza excepcion de articulo invalido)
		try {
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(1), 3);
			miComercio.traerCarrito(1).agregar(miComercio.traerArticulo(1), 3);//No agrega ya que el carrito esta cerrado
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 

		try {
			miComercio.traerCarrito(2).imprimirListadoItems();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Sacamos una cantidad menor a la total
		try {
			miComercio.traerCarrito(2).sacar(miComercio.traerArticulo(1), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		miComercio.traerCarrito(2).imprimirListadoItems();
		
		//Sacamos unidades restantes
		try {
			miComercio.traerCarrito(2).sacar(miComercio.traerArticulo(1), 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		miComercio.traerCarrito(2).imprimirListadoItems();
		
		//Intentamos sacar un articulo que ya no existe
		try {
			miComercio.traerCarrito(2).sacar(miComercio.traerArticulo(1), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//CASO DE USO: CERRAR CARRITO

		try {
			miComercio.cobrarCarrito(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
		//Probamos el ticket
		try {
			miComercio.traerCarrito(2).agregar(miComercio.traerArticulo(1), 8);
			miComercio.cobrarCarrito(juan);
			miComercio.traerCarrito(2).mostrarTicket();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//El carrito ya esta cerrado, lanza excepcion
		try {
			miComercio.cobrarCarrito(juan);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

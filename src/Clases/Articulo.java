package Clases;

public class Articulo {
	
	private int id;
	private String nombre;
	private String codBarras;
	private double precio;
	
	
	//Constructor
	
	public Articulo(int id, String nombre, String codBarras, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.codBarras = codBarras;
		this.precio = precio;
	}

	//Getters y setters

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodBarras() {
		return codBarras;
	}


	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	
	public boolean validarCodBarras(String codBarras) {

		int numCodBarras[] = new int[13];
		int par = 0, impar = 0, total = 0, codVerificador = 0;

		for (int i = 0; i < codBarras.length(); i++) {
			numCodBarras[i] = Character.getNumericValue(codBarras.charAt(i));//Primero convierto el "String" codBarras a valor numerico
			if (i == codBarras.length() - 1) {
				codVerificador = numCodBarras[i];//El ultimo digito del codigo de barras es considerado como el "codigo verificador"
			} else if (i % 2 == 0) {
				par += numCodBarras[i];
			} else {
				impar += numCodBarras[i];
			}
		}
		impar *= 3;
		total = par + impar;//Luego de sumar los totales se busca redondear el total hacia la decena mas cercana
		if (total % 10 > 5) {
			while (total % 10 != 0) {
				total++;
				codVerificador--;
			}
		}
		else if(total % 10 < 5) {
			while (total % 10 > 0) {
				total--;
				codVerificador--;//Para saber si el codigo de barras es correcto cuando el total redondee a la decena mas cercana 
			}					//la diferencia entre ese redondeo y el codVerificador deberia ser 0
		}
		else {
			codVerificador -= 5;
		}
		if (codVerificador == 0) {
			return true;
		} else
			return false;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}

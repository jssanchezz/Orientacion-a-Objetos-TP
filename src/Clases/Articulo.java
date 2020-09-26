
package Clases;

public class Articulo {
	
	private int id;
	private String nombre;
	private String codBarras;
	private double precio;
	
	
	//Constructor
	
	public Articulo(int id, String nombre, String codBarras, double precio) throws Exception{
		super();
		this.id = id;
		this.nombre = nombre;
		setCodBarras(codBarras);
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


	public void setCodBarras(String codBarras)throws Exception {
		boolean valido = validarCodBarras(codBarras);
		if(valido) {
			this.codBarras = codBarras;
		}else {
			throw new Exception ("Codigo de barras no valido");
		}
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	//Metodo de clase
	
	public boolean validarCodBarras(String cod) {
		boolean valido = false;
		if (cod.length() == 13) {
		int sumaPares=0;
		int sumaImpares=0;
		int codigoVerif=0;
		    for  (int i = 1; i< 13; i++){
		        int numero= Integer.parseInt(cod.substring(i, i+1));
		        if (i%2==0){
		            sumaPares=sumaPares+numero;
		        }
		        else{
		            sumaImpares=sumaImpares+numero;
		        }
		    }
		    int resImpares = sumaImpares*3;
		    int sumaParImp = resImpares+sumaPares;
		    codigoVerif = ((sumaParImp/10)+1)*10-sumaParImp;
		    if (codigoVerif<10) {
		        valido = true;
		    }
		}
		return valido;
	}
}


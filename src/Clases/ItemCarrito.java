package Clases;

public class ItemCarrito {
	
	private Articulo articulo;
	private int cantidad;
	
	public ItemCarrito(Articulo articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double calcularSubTotalItem() {
		return articulo.getPrecio()*cantidad;
	}

	@Override
	public String toString() {
		return articulo + "\t" + cantidad + "\t\t" + calcularSubTotalItem();
	}

	
}

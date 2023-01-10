package clases;

public class LineaFactura extends Factura {
	private int numero;
	private Articulo articulo;
	private double cantidad;
	
	public LineaFactura(int numero, Articulo articulo, double cantidad) {
		super();
		this.numero = numero;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	
	public LineaFactura() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
    public double precioTotal() {
		double total;
		total=0;
		total= articulo.getPrecio()*getCantidad();
		
		return total;
	}
    
    public void mostrarEnPantalla() {
		System.out.println(
				this.numero+ "\t" + 
				this.articulo.getName()+ "\t"+ this.articulo.getPrecio()+ "\t"+
				this.cantidad + "\t" +
				this.precioTotal());
	}
	
	
}

package clases;

public class Refresco extends Articulo {
	private String sabor;
	private boolean zumo;
	private boolean gaseoso;
	private int cantidadAzucar;

	public Refresco(String sabor, boolean zumo, boolean gaseoso, int cantidadAzucar) {
		super();
		this.sabor = sabor;
		this.zumo = zumo;
		this.gaseoso=gaseoso;
		this.cantidadAzucar = cantidadAzucar;
	}

	public Refresco() {

	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public boolean getZumo() {
		return zumo;
	}

	public void setZumo(boolean zumo) {
		this.zumo = zumo;
	}
	
	public boolean isGaseoso() {
		return gaseoso;
	}

	public void setGaseoso(boolean gaseoso) {
		this.gaseoso = gaseoso;
	}

	public int getCantidadAzucar() {
		return cantidadAzucar;
	}

	public void setCantidadAzucar(int cantidadAzucar) {
		this.cantidadAzucar = cantidadAzucar;
	}

	public void visualizarPropiedades() {

		System.out.println(" Sabor: " + this.sabor + " Zumo: " + this.zumo + " Gaseoso: " +this.gaseoso+ " CantidadAzucar: " + this.cantidadAzucar);
	}

	public void visualizarArticulo() {
		System.out.println(super.toString() + " Sabor: " + this.sabor + " Zumo: " + this.zumo + " Cantidad azucar"
				+ this.cantidadAzucar);
	}
	public String paraFichero() {
		
		return super.paraFichero()+ this.sabor+ ":" +this.zumo +":" +this.gaseoso+":"+this.cantidadAzucar;
	}

	public boolean saludable() {
		if (cantidadAzucar<20) {
			return true;
		}
		else {
			return false;
		}
	}

	public void precioTotal() {
		double total;
		total = 0;
		total = getPrecio() + Factura.IVA;
		System.out.println("El precio total es:" + total);

	}

}

package clases;

public class Refresco extends Articulo {
	private String sabor;
	private boolean zumo;
	private int cantidadAzucar;

	public Refresco(String sabor, boolean zumo, int cantidadAzucar) {
		super();
		this.sabor = sabor;
		this.zumo = zumo;
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

	public int getCantidadAzucar() {
		return cantidadAzucar;
	}

	public void setCantidadAzucar(int cantidadAzucar) {
		this.cantidadAzucar = cantidadAzucar;
	}

	public void visualizarPropiedades(Refresco refresco) {
		System.out.println(" Sabor: " + this.getSabor() + " Zumo: " + this.getZumo() + " Cantidad azucar"
				+ this.getCantidadAzucar());
	}

	public boolean esSaludable() {
		if (cantidadAzucar < 20) {
			return true;
		} else {
			return false;
		}
	}

}

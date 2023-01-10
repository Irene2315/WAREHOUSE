package clases;

import interfáces.Alcoholico;

public class Cerveza extends Articulo implements Alcoholico {
	private String origen;
	private String cereales;
	private double gradosAlcohol;

	public Cerveza(String origen, String cereales, double gradosAlcohol) {
		super();
		this.origen = origen;
		this.cereales = cereales;
		this.gradosAlcohol = gradosAlcohol;
	}

	public Cerveza() {

	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getCereales() {
		return cereales;
	}

	public void setCereales(String cereales) {
		this.cereales = cereales;
	}

	public double getGradosAlcohol() {
		return gradosAlcohol;
	}

	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}

	public void visualizarArticulo() {
		System.out.println(super.toString() + "Origen=" + this.origen + " Cereales: " + this.cereales
				+ " GradosAlcohol: " + this.gradosAlcohol);
	}

	public boolean saludable() {
		if (cereales.toLowerCase().equals("lupulo")) {
			return true;
		} else {
			return false;
		}
	}

	public void precioTotal() {
		double total;
		total = 0;
		total = getPrecio() + Factura.IVA + calcularTasa();
		System.out.println("El precio total es:" + total);

	}

	public boolean esFuerte() {

		if (gradosAlcohol > 7.0) {
			return true;
		} else {
			return false;
		}

	}

	public double calcularTasa() {
		double total;
		if (esFuerte() == true) {
			total = (getCapacidadBotella() * TASA_BEBIDAS_FUERTES / 10000);
		} else {
			total = (getCapacidadBotella() * TASA_BEBIDAS_DEBILES / 10000);
		}
		return total;
	}

}

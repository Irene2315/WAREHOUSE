package clases;

import interfáces.Alcoholico;

public class Vino extends Articulo  implements Alcoholico{
	
	private String color;
	private String origen;
	private int anio;
	private String tipoDeUva;
	private double gradosAlcohol;
	
	public Vino(String color, String origen, int anio, String tipoDeUva, double gradosAlcohol) {
		super();
		this.color = color;
		this.origen = origen;
		this.anio = anio;
		this.tipoDeUva = tipoDeUva;
		this.gradosAlcohol = gradosAlcohol;
	}
	
	public Vino() {
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getTipoDeUva() {
		return tipoDeUva;
	}

	public void setTipoDeUva(String tipoDeUva) {
		this.tipoDeUva = tipoDeUva;
	}

	public double getGradosAlcohol() {
		return gradosAlcohol;
	}

	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}
	
	public void visualizarPropiedades() {
		super.visualizarArticulo();
		System.out.print("Color: " + this.color + " Origen: " + this.origen + " Añio: " + this.anio + " TipoDeUva: " + this.tipoDeUva +
		 " GradosAlcohol: " + this.gradosAlcohol);
	}
	
	public boolean esFuerte() {
		
		if (gradosAlcohol>13.5) {
		      return true;
		}
		else {
			 return false;
		}
		
		
	}
	
	public double calcularTasa() {
		double total;
		if(esFuerte()==true) {
			total= (getCapacidadBotella()*TASA_BEBIDAS_FUERTES/10000);
		}
		else {
			total= (getCapacidadBotella()*TASA_BEBIDAS_DEBILES/10000);
		}
		return total;
	}
	
	
}

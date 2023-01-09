package clases;

import java.util.ArrayList;

public class   Articulo {

	private String code;
	private String name;
	private int capacidadBotella;
	private double precio;
	private int stock;

	public Articulo(String code, String name, int capacidadBotella, double precio, int stock) {
		this.code = code;
		this.name = name;
		this.capacidadBotella = capacidadBotella;
		this.precio = precio;
		this.stock = stock;
	}

	public Articulo() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacidadBotella() {
		return capacidadBotella;
	}

	public void setCapacidadBotella(int capacidadBotella) {
		this.capacidadBotella = capacidadBotella;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	

	

	public void incrementarStock(int cantidad) {
		int total;
		total = 0;
		total = total + cantidad;
		System.out.println("El stock actual es de " + total + " unidades");
	}

	public void disminuirStock(int cantidad) {
		int total;
		total = 0;
		total = total - cantidad;
		System.out.println("El stock actual es de " + total + " unidades");
	}

	public void visualizarArticulo() {
		System.out.println( "Code: " + this.code +  "Name: " + this.name + "CapacidadBotella: " + this.capacidadBotella + 
				" Precio="+ this.precio + "Stock: " + this.stock );
		
	}

	public boolean saludable(ArrayList<Articulo> articulos, String clase, String code_user) {

		boolean resultado;
		resultado = false;
		for (int i = 0; i < articulos.size(); i++) {
			if (code == code_user) {
				if (clase.equals("refresco")) {
					// resultado= Refresco.esSaludable(articulos.get(i));
				} else if (clase.equals("vino")) {
					/*
					 * if (Vino.getOrigen.equals("navarra")) { resultado=true; } else {
					 * resultado=false; }
					 * 
					 * 
					 */
				} else { // es cerveza
					resultado = true;
				}

			}
		}
		return resultado;

	}

	public void precioTotal(ArrayList<Articulo> articulos) {
		double total;
		total = 0;
		for (int i = 0; i < articulos.size(); i++) {
			total = getPrecio() + total;
		}
		System.out.println("El precio total es:" + total);
	}

}

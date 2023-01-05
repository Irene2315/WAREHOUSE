package clases;

public class Cerveza extends Articulo {
 private String origen;
 private String cereales;
 private double gradosAlcohol;
 
public Cerveza(String origen, String cereales, double gradosAlcohol) {
	super();
	this.origen = origen;
	this.cereales = cereales;
	this.gradosAlcohol = gradosAlcohol;
}
public Cerveza () {
	
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
 
}

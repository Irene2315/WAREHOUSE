package clases;

import java.util.Date;
import java.util.Scanner;

public class Factura {

	static int IVA= 21;
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	private static Scanner scanner;
	
	public Factura(int numero, String nombreEmpresa, Date fecha, String concepto) {
		super();
		this.numero = numero;
		this.nombreEmpresa = nombreEmpresa;
		this.fecha = fecha;
		this.concepto = concepto;
	}
	
	public Factura() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	public void addLinea(LineaFactura lineaFactura) {
		int numero;
		Articulo articulo = new Articulo();
		int cantidad;
		
		
		System.out.println("Introduce el número de artículo:");
		numero=scanner.nextInt();
		// leer y  recibir datos de articulo
		
		System.out.println("Introduce la cantidad: ");
		cantidad=scanner.nextInt();
		
		lineaFactura.setNumero(numero);
		lineaFactura.setArticulo(articulo);
		lineaFactura.setCantidad(cantidad);
			
	}
	
	
}

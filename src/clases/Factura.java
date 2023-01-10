package clases;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class Factura {

	static int IVA= 21;
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	private ArrayList<LineaFactura> lineasFacturas=new ArrayList<LineaFactura>();
	
	
	
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
		this.lineasFacturas.add(lineaFactura);

		
			
	}
	
  public void eliminarLinea(int numeroLinea) {
	 Iterator <LineaFactura> it = lineasFacturas.iterator();
	 while (it.hasNext()) {
		 LineaFactura lineaFactura =it.next();
		 if (numeroLinea == lineaFactura.getNumero()) {
			 it.remove();
			 System.out.println("La línea ha sido eliminada con exito eliminado con exito");
		 }
	 }
	 
	 
	 
  }
  
  public double precioTotal() {
	 
	  double total;
	  total=0;
	  for (int i = 0; i < lineasFacturas.size(); i++) {
		  
		total=lineasFacturas.get(i).precioTotal() +total;
	}
	  return total;
  }


public void mostrarEnPantalla() {
	System.out.println("Numero factura: " + this.numero + "\t\t" + this.nombreEmpresa);
	System.out.println("Fecha: " + formatoFechaString(this.fecha));
	System.out.println(this.concepto);
	
	System.out.println("num\tart.\tprecio\tcant.\ttotal");
	System.out.println("---\t----\t------\t-----\t-----");
	for (int i = 0; i < lineasFacturas.size(); i++) {
		LineaFactura lineaFactura = new LineaFactura();
		lineaFactura.mostrarEnPantalla();
	}
	
	System.out.println("\t\t\t---Total: " + this.precioTotal());
	
	
}

public void guardarEnFichero() throws FileNotFoundException {
	
	PrintWriter writer = new PrintWriter("facturas/" +nombreFichero());
	
	writer.close();
}

public String nombreFichero() {
	String nombreDelFichero = getNumero() + "_" + getFecha() + "_factura.txt";
	
	return nombreDelFichero;
}
  
public static Date formatoFechaDate(String fechaString) throws ParseException {
	Date fecha_factura;
	SimpleDateFormat formatoLecturaFecha= new SimpleDateFormat("dd-MM-yyyy");
	fecha_factura= formatoLecturaFecha.parse(fechaString);
	return fecha_factura;
}

public static String formatoFechaString(Date fecha) {
	String fechaString;
	SimpleDateFormat fecha_impresion= new SimpleDateFormat("dd-MM-yyyy");
	fechaString=fecha_impresion.format(fecha);
	return fechaString;
} 
	
	
	
}

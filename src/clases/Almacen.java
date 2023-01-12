package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Almacen {
	static ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	static File file = new File("inventario_almacen/productos_almacen.txt");

	public static void cargarDatos() throws FileNotFoundException {
		Scanner lectorFichero = new Scanner(file);
		String linea;
		String[] partes;

		while (lectorFichero.hasNext()) {
			linea = lectorFichero.nextLine();
			partes = linea.split(":");

			if (partes[1].equals("cerveza")) {

				Cerveza cerveza = new Cerveza();
				cerveza.setCode(partes[0]);
				cerveza.setName(partes[1]);
				cerveza.setMark(partes[2]);
				cerveza.setCapacidadBotella(Integer.parseInt(partes[3]));
				cerveza.setPrecio(Double.parseDouble(partes[4]));
				cerveza.setStock(Integer.parseInt(partes[5]));
				cerveza.setOrigen(partes[6]);
				cerveza.setCereales(partes[7]);
				cerveza.setGradosAlcohol(Double.parseDouble(partes[8]));

				articulos.add(cerveza);

			}
			if (partes[1].equals("vino")) {

				Vino vino = new Vino();
				vino.setCode(partes[0]);
				vino.setName(partes[1]);
				vino.setMark(partes[2]);
				vino.setCapacidadBotella(Integer.parseInt(partes[3]));
				vino.setPrecio(Double.parseDouble(partes[4]));
				vino.setStock(Integer.parseInt(partes[5]));
				vino.setColor(partes[6]);
				vino.setOrigen(partes[7]);
				vino.setAnio(Integer.parseInt(partes[8]));
				vino.setTipoDeUva(partes[9]);
				vino.setGradosAlcohol(Double.parseDouble(partes[10]));

				articulos.add(vino);
			}
			if (partes[1].equals("refresco")) {
				Refresco refresco = new Refresco();
				refresco.setCode(partes[0]);
				refresco.setName(partes[1]);
				refresco.setMark(partes[2]);
				refresco.setCapacidadBotella(Integer.parseInt(partes[3]));
				refresco.setPrecio(Double.parseDouble(partes[4]));
				refresco.setStock(Integer.parseInt(partes[5]));
				refresco.setSabor(partes[6]);
				refresco.setZumo(Boolean.parseBoolean(partes[7]));
				refresco.setGaseoso(Boolean.parseBoolean(partes[8]));
				refresco.setCantidadAzucar(Integer.parseInt(partes[9]));

				articulos.add(refresco);

			}

		}

		lectorFichero.close();

	}

	

	public static Articulo elMasCaro() {
		double precio = 0;
		Articulo articulo_caro = null;
		for (Articulo articulo : articulos) {
			if (articulo.getPrecio() > precio) {
				precio = articulo.getPrecio();
				articulo_caro = articulo;
			}
		}
		return articulo_caro;

	}

	public static double precio(String codigoProducto) {
		double precio = 0;
		for (Articulo articulo : articulos) {
			if (articulo.getCode().equals(codigoProducto)) {
				precio = articulo.getPrecio();
			}
		}
		return precio;
	}

	public static boolean hayStock(String codigoProducto) {
		boolean stock = false;
		for (Articulo articulo : articulos) {
			if (articulo.getCode().equals(codigoProducto)) {
				if (articulo.getStock() > 0) {
					stock = true;
				} else {
					stock = false;
				}
			}
		}
		return stock;
	}

	public static ArrayList<Articulo> stockJusto(ArrayList<Articulo> articulos) {
		int i = 0;
		ArrayList<Articulo> menor_10 = new ArrayList<Articulo>();
		for (Articulo articulo : articulos) {
			if (articulo.getStock() < 10) {
				menor_10.add(articulos.get(i));
				i = i + 1;
			}
		}
		
		return menor_10;
	}

	public static Articulo articulo(String codigoProducto) {
		int i = 0;
		Articulo articulo_codigo=null;
		for (Articulo articulo : articulos) {
			if (articulo.getCode().equals(codigoProducto)) {
				articulo_codigo=(articulos.get(i));
				
			}
			i = i + 1;
		}
		return articulo_codigo;
		
	}

	public static boolean disponibilidad(int cantidad, String codigoProducto) {
		boolean stock = false;
		for (Articulo articulo : articulos) {
			if (articulo.getCode().equals(codigoProducto)) {
				if (articulo.getStock() > cantidad) {
					stock = true;
				} else {
					stock = false;
				}
			}
		}
		return stock;
	}

	public static ArrayList<Articulo> equivalente(Articulo articulo) {
		double diferencia_1 = 0;
		double diferencia_2 = 0;
		ArrayList<Articulo> equivalentes = new ArrayList<Articulo>();
		for (Articulo articulo_equivalente : articulos) {
			if (articulo.getName().equals(articulo_equivalente.getName())) {
				diferencia_1 = articulo.getPrecio() - articulo_equivalente.getPrecio();
				diferencia_2 = articulo_equivalente.getPrecio() - articulo.getPrecio();
				if ((diferencia_1 == 0.2) || (diferencia_2 == 0.2)) {
					equivalentes.add(articulo);
					equivalentes.add(articulo_equivalente);

				}
			}
		}
		return equivalentes;
	}

	public static ArrayList<Articulo> ordenarPorPrecio(String orden) {
		
		ArrayList<Articulo> ordenado = new ArrayList<Articulo>();

		if (orden == "ACS") { // menor a mayor
			class menorMayorP implements Comparator<Articulo> {

				public int compare(Articulo a1, Articulo a2) {
					if (a1.getPrecio() > a2.getPrecio()) {
						return 1;
					} else if (a1.getPrecio() < a2.getPrecio()) {

						return -1;
					} else {
						return 0;
					}

				}

			}
			// ordenado=articulos.sort(menorMayorP.compare(articulos,new menorMayorP()));
			// Collections.sort(articulos,new menorMayorP());
		}

		if (orden == "DESC") { // mayor a menor

			class mayorMenorP implements Comparator<Articulo> {
				public int compare(Articulo a1, Articulo a2) {
					if (a1.getPrecio() > a2.getPrecio()) {
						return -1;
					} else if (a1.getPrecio() < a2.getPrecio()) {

						return 1;
					} else {
						return 0;
					}

				}
			}
			// ordenado=articulos.sort(mayorMenorP.compare(articulos,new menorMayorP()));
			// Collections.sort(articulos,new menorMayorP());

		}
		return ordenado;
	}
	
	public static ArrayList<Articulo> ordenarPorStock(String orden){
		ArrayList<Articulo> ordenado = new ArrayList<Articulo>();
		
		if (orden=="ASC") {
			class menorMayorS implements Comparator<Articulo> {

				public int compare(Articulo a1, Articulo a2) {
					if (a1.getStock() > a2.getStock()) {
						return 1;
					} else if (a1.getStock() < a2.getStock()) {

						return -1;
					} else {
						return 0;
					}

				}

			}
			// ordenado=articulos.sort(menorMayorS.compare(articulos,new menorMayorP()));
			//Collections.sort(articulos,new menorMayorS());
		}
	  if (orden == "DESC") {
		  
		  class mayorMenorS implements Comparator <Articulo>{
			  public int compare(Articulo a1, Articulo a2) {
					if (a1.getStock() > a2.getStock()) {
						return -1;
					} else if (a1.getStock() < a2.getStock()) {

						return 1;
					} else {
						return 0;
					}

				}

		  }
		// ordenado=articulos.sort(menorMayorS.compare(articulos,new menorMayorP()));
		// Collections.sort(articulos,new menorMayorS());
		  
	  }
	  return ordenado;
	}
	

}

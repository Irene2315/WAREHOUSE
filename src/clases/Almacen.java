package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Almacen {
	ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	File file = new File("inventario_almacen/productos_almacen.txt");

	public void cargarDatos() throws FileNotFoundException {
		Scanner lectorFichero = new Scanner(file);
		String linea;
		String[] partes;

		while (lectorFichero.hasNext()) {
			linea = lectorFichero.nextLine();
			partes = linea.split(":");

			if (partes[0].equals("cerveza")) {
				
				 Cerveza cerveza = new Cerveza();
				 cerveza.setCode(partes[1]);
				 cerveza.setName(partes[2]);
				 cerveza.setCapacidadBotella(Integer.parseInt(partes[3]));
				 cerveza.setPrecio(Double.parseDouble(partes[4]));
				 cerveza.setStock(Integer.parseInt(partes[5]));
				 cerveza.setOrigen(partes[6]);
				 cerveza.setCereales(partes[7]);
				 cerveza.setGradosAlcohol(Double.parseDouble(partes[8]) );
				 

				articulos.add(cerveza);

			}
			if (partes[0].equals("vino")) {
				
				 Vino vino = new Vino();
				 vino.setCode(partes[1]);
				 vino.setName(partes[2]);
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
			if (partes[0].equals("refresco")) {
				Refresco refresco = new Refresco();
				refresco.setCode(partes[1]);
				refresco.setName(partes[2]);
				refresco.setCapacidadBotella(Integer.parseInt(partes[3]));
				refresco.setPrecio(Double.parseDouble(partes[4]));
				refresco.setStock(Integer.parseInt(partes[5]));
				refresco.setSabor(partes[6]);
				refresco.setZumo(Boolean.parseBoolean(partes [7]));
				refresco.setCantidadAzucar(Integer. parseInt (partes[7]));
				
			

				articulos.add(refresco);

			}

		}

		lectorFichero.close();
	

	}
	
	public Articulo elMasCaro() {
		for (int i = 0; i < articulos.size(); i++) {
			double total;
			int posicion;
			Articulo articulo ;
			posicion=-1;
			total=0;
			/*
			 * if(articulos.getPrecio()>total) {
				total=articulos.getPrecio();
				posicion=i;
			}
		for (int j = 0; j < articulos.size(); j++) {
			if (posicion==j) {
				articulo=articulos[j];
			}
		}
		 * 
			 * 
			 * 
			 */
		
			return(articulo);
			
			
		}
		
	}

}

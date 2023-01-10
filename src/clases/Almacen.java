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
				/*
				 * Cerveza guardar_cerveza = new Cerveza ( (partes[1]) , (partes[2]),
				 * Integer.parseInt(partes[3]), Double.parseDouble(partes[4]),
				 * Integer.parseInt(partes[5]), (partes[6]), (partes[7])
				 * ,Double.parseDouble(partes[8]) );
				 */

				// articulos.add(guardar_cerveza);

			}
			if (partes[0].equals("vino")) {
				/*
				 * Vino guardar_vino = new Vino((partes[1]),(partes[2]), Integer.
				 * parseInt(partes[3]),Double.parseDouble(partes[4]),
				 * Integer.parseInt(partes[5]),(partes[6]),(partes[7]), Integer.
				 * parseInt(partes[8]), (partes[9]), Double.parseDouble(partes[10]));
				 * 
				 */

				// articulos.add(guardar_vino);
			}
			if (partes[0].equals("refresco")) {

				/*
				 * Refresco guardar_refresco = new Refresco ((partes[1]),(partes[2]), Integer.
				 * parseInt(partes[3]),Double.parseDouble(partes[4]), (partes [5]),
				 * Boolean.parseBoolean(partes [6]), Integer. parseInt (partes[7]);
				 * 
				 */

				// articulos.add(guardar_refresco);

			}

		}

		lectorFichero.close();
		// return articulos;

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

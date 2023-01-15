package gestor;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import clases.Almacen;
import clases.Articulo;

public class GestorAlmacenApp {

	public static void run() throws FileNotFoundException {
		final String Nombre_Fichero = ("inventario_almacen/productos_almacen.txt");

		ArrayList<Articulo> articulos = Almacen.cargarDatos(Nombre_Fichero);
		Scanner teclado = new Scanner(System.in);
		final int REALIZAR_VENTA = 1;
		final int REALIZAR_COMPRA = 2;
		final int VER_ARTICULOS_SALUDABLES = 3;
		final int VER_ARTICULO_MAS_CARO = 4;
		final int VER_ARTICULOS_CON_MENOS_STOCK_X = 5;
		final int SALIR = 0;
		int opcion_menu;

		do {
			System.out.println("------MENU-------");
			System.out.println("¿Qué desea realizar?");
			System.out.println(REALIZAR_VENTA + ". Comprar artículo");
			System.out.println(REALIZAR_COMPRA + ". Vender artículo");
			System.out.println(VER_ARTICULOS_SALUDABLES + ". Ver artículos saludable");
			System.out.println(VER_ARTICULO_MAS_CARO + ". Ver artículo más caro ");
			System.out.println(VER_ARTICULOS_CON_MENOS_STOCK_X + ". Ver artículos con menos Stock que x");
			System.out.println(SALIR + ". Salir");
			System.out.println("*******************");
			System.out.println("Elije una de las opciones");
			opcion_menu = teclado.nextInt();
			switch (opcion_menu) {
			
			case REALIZAR_VENTA:
				String articulo_codigo_c;
				Articulo articulo_c = null;
				int cantidad;
				System.out.println("Introduzca el codigo de articulo que desea comprar, si ha terminado su compra escriba salir");
				teclado.nextLine();
				articulo_codigo_c = teclado.nextLine();
				
				while (!articulo_codigo_c.toLowerCase().equals("salir") ) {
				//actualizador 
				System.out.println("introduce la cantidad de ese articulo que quieres comprar");
				cantidad = teclado.nextInt();
				articulo_c = Almacen.articulo(articulo_codigo_c);
				Articulo.incrementarStock(articulo_c, cantidad);
				Almacen.guardar(Nombre_Fichero, articulos);
				
				System.out.println("Introduzca el codigo de articulo que desea comprar, si ha terminado su compra escriba salir");
				teclado.nextLine();
				articulo_codigo_c = teclado.nextLine();
				}
				
				break;
			case REALIZAR_COMPRA:
				String articulo_codigo_v;
				Articulo articulo_v = null;
				System.out.println("Introduzca el codigo de articulo que desea vender");
				teclado.nextLine();
				articulo_codigo_v = teclado.nextLine();

				articulo_v = Almacen.articulo(articulo_codigo_v);
				Articulo.disminuirStock(articulo_v, articulo_v.getStock());
				Almacen.guardar(Nombre_Fichero, articulos);
				break;
			
			case VER_ARTICULOS_SALUDABLES:
				System.out.println("Tercera opcion selecinada ");
				break;
			case VER_ARTICULO_MAS_CARO:
				Articulo articulo_caro = null;
				articulo_caro = Almacen.elMasCaro();
				// Articulo.visualizarArticulo();
				break;
			case VER_ARTICULOS_CON_MENOS_STOCK_X:
				System.out.println("Cuarta opcion selecinada ");
				break;

			case SALIR:

			}
			System.out.println("");
		} while (opcion_menu != SALIR);
		teclado.close();
	}

}

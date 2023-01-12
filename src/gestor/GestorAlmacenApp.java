package gestor;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Almacen;
import clases.Articulo;

public class GestorAlmacenApp {
	
		
	 public static void run() throws FileNotFoundException {
		 ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		 Almacen.cargarDatos();
		 Almacen.todos(articulos);
		 Scanner teclado = new Scanner(System.in);
		final int REALIZAR_VENTA = 1;
		final int REALIZAR_COMPRA = 2;
		final int VER_ARTICULOS_SALUDABLES = 3;
		final int VER_ARTICULO_MAS_CARO = 4;
		final int VER_ARTICULOS_CON_MENOS_STOCK_10 = 5;
		final int SALIR = 0;
		int opcion_menu;

		do {
			System.out.println("------MENU-------");
			System.out.println("¿Qué desea realizar?");
			System.out.println(REALIZAR_VENTA + ". 1-Vender artículo");
			System.out.println(REALIZAR_COMPRA + ". 2-Comprar artículo");
			System.out.println(VER_ARTICULOS_SALUDABLES + ". 3-Ver artículos saludable");
			System.out.println(VER_ARTICULO_MAS_CARO + ". 4-Ver artículo más caro ");
			System.out.println(VER_ARTICULOS_CON_MENOS_STOCK_10 +" 5-Ver artículos con menos Stock que 10");
			System.out.println(SALIR + ". Salir");
			System.out.println("*******************");
			System.out.println("Elije una de las opciones");
			opcion_menu = teclado.nextInt();
			switch (opcion_menu) {
			case REALIZAR_VENTA:
				System.out.println("Primera opcion selecionada");

				break;
			case REALIZAR_COMPRA:
				System.out.println("Segunda opcion selecionada");
				break;
			case VER_ARTICULOS_SALUDABLES:
				System.out.println("Tercera opcion selecinada ");
				break;
			case VER_ARTICULO_MAS_CARO:
				System.out.println("Tercera opcion selecinada ");
				break;
			case VER_ARTICULOS_CON_MENOS_STOCK_10:
				System.out.println("Tercera opcion selecinada ");
				break;

			case SALIR:

			}
			System.out.println("");
		} while (opcion_menu != SALIR);
		teclado.close();

	 }
	
}

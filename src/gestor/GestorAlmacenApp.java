package gestor;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import clases.Almacen;
import clases.Articulo;
import clases.Factura;
import clases.LineaFactura;

public class GestorAlmacenApp {

	public static void run() throws FileNotFoundException, ParseException {
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
				
				// datos de articulo
				String articulo_codigo_c;
				Articulo articulo_c = null;
				int cantidad_1;

				// datos de linea factura
				LineaFactura lineaFactura = new LineaFactura();
				int numero_linea = 0;
				// Articulo articulo_c
				// int cantidad_1

				// crear factura
				Factura factura = new Factura();
				int numero_factura;
				String nombreEmpresa_factura;
				String String_fecha_factura;
				String concepto_factura;

				System.out.println(
						"Introduzca el codigo de articulo que desea vender, si ha terminado su compra escriba salir");
				teclado.nextLine();
				articulo_codigo_c = teclado.nextLine();

				while (!articulo_codigo_c.toLowerCase().equals("salir")) {

					numero_linea = numero_linea + 1;
					// actualizador
					System.out.println("introduce la cantidad de ese articulo que quieres vender");
					cantidad_1 = teclado.nextInt();
					articulo_c = Almacen.articulo(articulo_codigo_c);
					Articulo.disminuirStock(articulo_c, cantidad_1);
					Almacen.guardar(Nombre_Fichero, articulos);

					// añadir linea
					lineaFactura.setNumero(numero_linea);
					lineaFactura.setArticulo(articulo_c);
					lineaFactura.setCantidad(cantidad_1);
					factura.addLinea(lineaFactura);

					System.out.println(
							"Introduzca el codigo de articulo que desea vender, si ha terminado su compra escriba salir");
					teclado.nextLine();
					articulo_codigo_c = teclado.nextLine();
				}

				// datos de la factura
				System.out.println("---Introduzca los datos de factura---");
				System.out.println("Introduce el numero");
				numero_factura = teclado.nextInt();
				teclado.nextLine();
				System.out.println("Introduce el nombre de empresa");
				nombreEmpresa_factura = teclado.nextLine();
				System.out.println("Introduce la fecha de la factura en este formato (dd-MM-yyyy)");
				String_fecha_factura = teclado.nextLine();

				System.out.println("Introduce el concepto de la factura");
				concepto_factura = teclado.nextLine();

				factura.setNumero(numero_factura);
				factura.setNombreEmpresa(nombreEmpresa_factura);
				factura.setFecha(Factura.formatoFechaDate(String_fecha_factura));
				factura.setConcepto(concepto_factura);

				// mostraremos en pantalla nuestra factura
				factura.mostrarEnPantalla();
				
				break;
				
			case REALIZAR_COMPRA:
				String articulo_codigo_v;
				Articulo articulo_v = null;
				int cantidad_2;
				System.out.println(
						"Introduzca el codigo de articulo que desea comprar, si ha terminado su compra escriba salir");
				teclado.nextLine();
				articulo_codigo_v = teclado.nextLine();

				while (!articulo_codigo_v.toLowerCase().equals("salir")) {
					// actualizador stock
					System.out.println("introduce la cantidad de ese articulo que quieres comprar");
					cantidad_2 = teclado.nextInt();
					articulo_v = Almacen.articulo(articulo_codigo_v);
					Articulo.incrementarStock(articulo_v, cantidad_2);
					Almacen.guardar(Nombre_Fichero, articulos);
					System.out.println(
							"Introduzca el codigo de articulo que desea comprar, si ha terminado su compra escriba salir");
					teclado.nextLine();
					articulo_codigo_v = teclado.nextLine();
				}

				break;

			case VER_ARTICULOS_SALUDABLES:
				for (Articulo articulo : articulos) {
					if(articulo.saludable()==true) {
						//no coge refresco
						articulo.visualizarArticulo();
					}
				}
				break;
			case VER_ARTICULO_MAS_CARO:
				Articulo articulo_caro = null;
				articulo_caro = Almacen.elMasCaro();
			    articulo_caro.visualizarArticulo();
				break;
			case VER_ARTICULOS_CON_MENOS_STOCK_X:
				int stock_x;
				System.out.println("Introduce la fraja de stock mínimo que quieres vilualizar ");
				stock_x=teclado.nextInt();
				for (Articulo articulo : articulos) {
					if(articulo.getStock()<stock_x) {
						articulo.visualizarArticulo();
					}
				}
				break;

			case SALIR:

			}
			System.out.println("");
		} while (opcion_menu != SALIR);
		teclado.close();
	}

}

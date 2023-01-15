package clases;



public abstract  class  Articulo  {

	private String code;
	private String name;
	private String mark;
	private int capacidadBotella;
	private double precio;
	private int stock;

	public Articulo(String code, String name,String mark, int capacidadBotella, double precio, int stock) {
		this.code = code;
		this.name = name;
		this.mark=mark;
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

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
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

	

	

	//el odjeto articulo es necesarío para actuliazar el almacen.
	public static void incrementarStock(Articulo articulo_c, int cantidad) {
		int total;
		total = 0;
		total = articulo_c.getStock() +cantidad;
		articulo_c.setStock(total);
		System.out.println("El stock actual es de " + total + " unidades");
	}

	// el odjeto artículo es necesarío para actualizar el almacén
	public static void disminuirStock(Articulo articulo_v,int cantidad) {
		int total;
		total = 0;
		total = articulo_v.getStock() -cantidad;
		articulo_v.setStock(total);
		System.out.println("El stock actual es de " + total + " unidades");
	}

	public abstract  void visualizarArticulo() ;
	
	
	public String toString() {
		return  "Codigo: " + this.code +  " Nombre: " + this.name + " Marca: " +this.mark +" CapacidadBotella: " + this.capacidadBotella + 
				" Precio: "+ this.precio + " Stock: " + this.stock;
	}
	public String paraFichero() {
		return this.code+ ":" +this.name +":" +this.mark+":"+this.capacidadBotella+":"+this.precio+":"+this.stock+ ":";
	}
	public abstract boolean saludable();

	public abstract  void precioTotal();
	
	//ordenar elementos de la lista
	public int ordernarPorPrecioMenorMayor( Articulo articulo) {
		int estado;
		
		if (this.getPrecio()> articulo.getPrecio()) {
			estado=1;
		}
		else if(this.getPrecio()< articulo.getPrecio()) {
			estado=-1;
		}
		else {
			estado=0;
		}
		return estado;
			
	}

	

}

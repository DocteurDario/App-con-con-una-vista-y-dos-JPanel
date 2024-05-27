package Dominio;

public class Peliculas {
	private final int id;
	private String nombre;
	private Categorias categoria;
	private static int contadorId;
	
	Peliculas() {
		this.id = 999999999;
	}
	
	public Peliculas(String nombre, Categorias categoria) {
		this.contadorId++;
		this.id = this.contadorId;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public static int getContadorId() {
		return contadorId;
	}

	public static void setContadorId(int contadorId) {
		Peliculas.contadorId = contadorId;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return nombre + " - " + categoria.toString();
	}
}

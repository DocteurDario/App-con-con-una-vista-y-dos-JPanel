package Dominio;

public class Categorias {
	private final int id;
	private String nombre;
	private static int contadorId;
	
	
	public Categorias() {
		this.contadorId++;
		this.id = this.contadorId;
		this.nombre = "vacio";
	}
	
	public Categorias(String nombre) {
		this.contadorId++;
		this.id = this.contadorId;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
}



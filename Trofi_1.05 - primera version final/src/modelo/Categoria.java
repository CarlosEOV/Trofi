package modelo;

public class Categoria {
	
	private int id;
	private String nombre;
	
	public Categoria(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}

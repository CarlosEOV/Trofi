package modelo;

public class Alimento {
	private String nombre;
	private String descripcion;
	private double costo;
	private int idAlimento;
	private int idCategoria;
	
	public Alimento(String nombre, String descripcion, double costo , int id, int cat_id) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		this.idAlimento = id;
		this.idCategoria = cat_id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getCosto() {
		return this.costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public int getIdAlimento() {
		return this.idAlimento;
	}
	
	public void setIdAlimento(int id) {
		this.idAlimento = id;
	}
	
	public int getIdCategoria() {
		return this.idCategoria;
	}
	
	public void setCat(int cat_id) {
		this.idCategoria = cat_id;
	}
	
	public boolean equals(Alimento compara) {
		return this.idAlimento == compara.idAlimento;
	}
}

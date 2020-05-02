package modelo;

import controlador.Carrito;

public class Cliente {
	
	private String nombre;
	private String a_paterno;
	private String a_materno;
	private String correo_e;
	private String contrasenia;
	private String telefono;
	private Carrito carrito;
	
	public Cliente(String correo_e, String nombre, String a_paterno, String a_materno, String contrasenia, String telefono) {
		this.nombre = nombre;
		this.a_paterno = a_paterno;
		this.a_materno = a_materno;
		this.correo_e = correo_e;
		this.contrasenia = contrasenia;
		this.telefono = telefono;
		this.carrito = new Carrito();
	}
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getAPaterno() {
		return a_paterno;
	}
	
	public void setAPaterno(String a_paterno) {
		this.a_paterno = a_paterno;
	}
	
	public String getAMaterno() {
		return a_materno;
	}
	
	public void setAMaterno(String a_materno) {
		this.a_materno = a_materno;
	}
	
	public String getCorreoE() {
		return correo_e;
	}
	
	public void setCorreoE(String correo_e) {
		this.correo_e = correo_e;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Carrito getCarrito() {
		return this.carrito;
	}
}

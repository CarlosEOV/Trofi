package modelo;

public class Repartidor {
	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private String correo_e;
	private String contrasenia;
	
	public Repartidor() {}
	
	public Repartidor(String email,String nombre, String apellido1,String apellido2,String password) {
		this.nombre=nombre;
		this.aPaterno = apellido1;
		this.aMaterno = apellido2;
		this.correo_e = email;
		this.contrasenia = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApaterno() {
		return aPaterno;
	}
	
	public void setApaterno(String apellido1) {
		this.aPaterno = apellido1;
	}
	
	public String getAmaterno() {
		return aMaterno;
	}
	
	public void setAmaterno(String apellido2) {
		this.aMaterno = apellido2;
	}
	
	public String getCorreo() {
		return correo_e;
	}
	
	public void setCorreo(String email) {
		this.correo_e = email;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String password) {
		this.contrasenia = password;
	}
}
package modelo;

public class Direccion {
	private String correo_e;
	private String direccion;
	
	public Direccion(String correo_e, String direccion) {
		this.correo_e = correo_e;
		this.direccion = direccion;
	}
	
	//getters y setters
	public String getCorreoE() {
		return correo_e;
	}
	
	public void setCorreoE(String correo_e) {
		this.correo_e = correo_e;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}

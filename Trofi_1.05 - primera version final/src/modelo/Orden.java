package modelo;

public class Orden {

	   String correo_cl;
	   int id_orden;
	   String estado_orden;
	   String dir_cliente;
	   String correo_rep;

	    public Orden(String correo_cl,int id_orden,String estado_orden,String dir_cliente,String correo_rep) {
	    	this.correo_cl = correo_cl;
	    	this.id_orden = id_orden;
	    	this.estado_orden = estado_orden;
	    	this.dir_cliente = dir_cliente;
	    	this.correo_rep = correo_rep;
	    }


		public String getCorreo_cl() {
			return correo_cl;
		}

		public int getId_orden() {
			return id_orden;
		}

		public String getEstado_orden() {
			return estado_orden;
		}

		public String getDireccion_cliente() {
			return dir_cliente;
		}

		public String getCorreo_rep() {
			return correo_rep;
		}
		
		public void setCorreo_cl(String correo_cl) {
			this.correo_cl = correo_cl;
		}


		public void setId_orden(int id_orden) {
			this.id_orden = id_orden;
		}


		public void setEstado_orden(String estado_orden) {
			this.estado_orden = estado_orden;
		}


		public void setDir_cliente(String dir_cliente) {
			this.dir_cliente = dir_cliente;
		}


		public void setCorreo_rep(String correo_rep) {
			this.correo_rep = correo_rep;
		}




	}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Administrador;
import modelo.Conexion;

public class AdministradorDAO {
	private Conexion con;
	private Connection connection;

	public AdministradorDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	// listar todos los productos
	public List<Administrador> listarAdministradores() throws SQLException {
		List<Administrador> listaAdministradores = new ArrayList<Administrador>();
		String sql = "SELECT * FROM administrador";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		while (resulSet.next()) {
			String correo_e = resulSet.getString("correo_e");
			String nombre = resulSet.getString("nombre");
			String a_paterno = resulSet.getString("a_paterno");
			String a_materno = resulSet.getString("a_materno");
			String contrasenia = resulSet.getString("contrasenia");
			Administrador admin = new Administrador(correo_e, nombre, a_paterno, a_materno, contrasenia);
			listaAdministradores.add(admin);
		}
		con.desconectar();
		return listaAdministradores;
	}

	// obtener por correo
	public Administrador obtenerPorCorreo(String correo) throws SQLException {
		Administrador admin = null;
		String sql = "SELECT * FROM administrador WHERE correo_e = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, correo);
		ResultSet res = statement.executeQuery();
		if (res.next()){
			admin = new Administrador(res.getString("correo_e"), res.getString("nombre"), res.getString("a_paterno"),
					res.getString("a_materno"), res.getString("contrasenia"));
		}
		res.close();
		con.desconectar();
		return admin;
	}
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Repartidor;
import modelo.Conexion;

public class RepartidorDAO {
	private Conexion con;
	private Connection connection;

	public RepartidorDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	// listar todos los productos
	public List<Repartidor> listarRepartidores() throws SQLException {
		List<Repartidor> listaRepartidores = new ArrayList<Repartidor>();
		String sql = "SELECT * FROM repartidor";
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
			Repartidor repartidor = new Repartidor(correo_e, nombre, a_paterno, a_materno, contrasenia);
			listaRepartidores.add(repartidor);
		}
		con.desconectar();
		return listaRepartidores;
	}

	// obtener por correo
	public Repartidor obtenerPorCorreo(String correo) throws SQLException {
		Repartidor admin = null;
		String sql = "SELECT * FROM repartidor WHERE correo_e = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, correo);
		ResultSet res = statement.executeQuery();
		if (res.next()){
			admin = new Repartidor(res.getString("correo_e"), res.getString("nombre"), res.getString("a_paterno"),
					res.getString("a_materno"), res.getString("contrasenia"));
		}
		res.close();
		con.desconectar();
		return admin;
	}
	
	public boolean agregarCuenta(Repartidor repartidor) throws SQLException {
		String sql = "INSERT INTO repartidor (correo_e, nombre, a_paterno, a_materno, contrasenia) VALUES (?, ?, ?, ?, SHA(?))";
		System.out.println("conectando");
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, repartidor.getCorreo());
		statement.setString(2, repartidor.getNombre());
		statement.setString(3, repartidor.getApaterno());
		statement.setString(4, repartidor.getAmaterno());
		statement.setString(5, repartidor.getContrasenia());
		System.out.println("agregado");
		boolean agregar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return agregar;
	}

}
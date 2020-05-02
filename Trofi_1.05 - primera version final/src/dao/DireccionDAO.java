package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Direccion;
import modelo.Conexion;

public class DireccionDAO {
	private Conexion con;
	private Connection connection;
	
	public DireccionDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	// Agregar direccion.
	public boolean agregarDireccion(Direccion direccion) throws SQLException {
		String sql = "INSERT INTO direccion_cliente (correo_e, direccion) VALUES (?, ?)";
		System.out.println("Conectando");
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, direccion.getCorreoE());
		statement.setString(2, direccion.getDireccion());
		System.out.println("Agregando la cosa");
		boolean agregar =  statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return agregar;
	}
	
	// Listar direcciones de un cliente.
	public List<Direccion> obtenerDirecciones(String correo_e) throws SQLException {
		List<Direccion> direcciones = new ArrayList<Direccion>();
		String sql = "SELECT * FROM direccion_cliente WHERE correo_e = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, correo_e);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			String correo = resultSet.getString("correo_e");
			String direccion = resultSet.getString("direccion");
			Direccion dir = new Direccion(correo, direccion);
			direcciones.add(dir);
		}
		con.desconectar();
		return direcciones;
	}
	
	// Eliminar direccion.
	public boolean eliminarDireccion(Direccion direccion) throws SQLException {
		boolean eliminar = false;
		String sql = "DELETE FROM direccion_cliente WHERE correo_e = ? and direccion = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, direccion.getCorreoE());
		statement.setString(2, direccion.getDireccion());
		eliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return eliminar;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Conexion;

public class CategoriaDAO {
	private Conexion con;
	private Connection connection;

	public CategoriaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//agregar un categoria
		public boolean agregarCategoria(Categoria categoria) throws SQLException {
			String sql = "INSERT INTO categoria (id_categoria, nombre) VALUES (?, ?)";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, categoria.getId());
			statement.setString(2, categoria.getNombre());
			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();
			return rowInserted;
			
		}

	// listar todos los categorias
	public List<Categoria> listarCategorias() throws SQLException {
		
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		String sql = "SELECT * FROM categoria";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		System.out.println("BD cat ready..");
		
		while (resulSet.next()) {
			int id = resulSet.getInt("id_categoria");
			String nombre = resulSet.getString("nombre");
			Categoria categoria = new Categoria(id, nombre);
			listaCategorias.add(categoria);
		}
		con.desconectar();
		System.out.println("List cat ready..");
		return listaCategorias;
	}
	
	// obtener por id
	public Categoria obtenerPorId(int id) throws SQLException {
		Categoria categoria = null;

		String sql = "SELECT * FROM categoria WHERE id_categoria= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			categoria = new Categoria(res.getInt("id_categoria"), res.getString("nombre"));
		}
		res.close();
		con.desconectar();

		return categoria;
	}
	
	// actualizar categoria
		public boolean editarCategoria(Categoria categoria) throws SQLException {
			boolean rowActualizar = false;
			String sql = "UPDATE categoria SET nombre=? WHERE id_categoria=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, categoria.getNombre());
			statement.setInt(2, categoria.getId());
			rowActualizar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();
			return rowActualizar;
		}
		
		//eliminar categoria
		public boolean eliminarCategoria(Categoria categoria) throws SQLException {
			boolean rowEliminar = false;
			String sql = "DELETE FROM categoria WHERE id_categoria=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, categoria.getId());

			rowEliminar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();

			return rowEliminar;
		}
}
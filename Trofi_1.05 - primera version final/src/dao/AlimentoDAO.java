package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Alimento;
import modelo.Conexion;

public class AlimentoDAO {
	private Conexion con;
	private Connection connection;

	public AlimentoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//agregar un alimento
		public boolean agregarAlimento(Alimento alimento) throws SQLException {
			String sql = "INSERT INTO alimento (id_categoria, id_alimento, nombre, descripcion, costo, foto) VALUES (?, ?, ?, ?,?,1)";
			System.out.println("hola");
			System.out.println(alimento.getDescripcion());
			System.out.println("hola");
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, alimento.getIdCategoria());
			statement.setInt(2, alimento.getIdAlimento());
			statement.setString(3, alimento.getNombre());
			statement.setString(4, alimento.getDescripcion());
			statement.setDouble(5, alimento.getCosto());
			System.out.println("hola");
			System.out.println(alimento.getDescripcion());
			System.out.println("hola2");
			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();
			return rowInserted;
			
		}

	// listar todos los alimentos
	public List<Alimento> listarAlimentos(int id_cat) throws SQLException {
		System.out.println("IDCATIN: "+ id_cat);
		List<Alimento> listaAlimentos = new ArrayList<Alimento>();
		String sql = "SELECT * FROM alimento WHERE id_categoria= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_cat);
		ResultSet resulSet = statement.executeQuery();
		System.out.println("BD alim ready..");
		System.out.println("Id cat: "+id_cat);
		while (resulSet.next()) {
			int id = resulSet.getInt("id_alimento");
			String nombre = resulSet.getString("nombre");
			System.out.println("alimento: "+ nombre);
			String descripcion = resulSet.getString("descripcion");
			Double costo = resulSet.getDouble("costo");
			
			Alimento alimento = new Alimento(nombre, descripcion, costo, id, id_cat);
			listaAlimentos.add(alimento);
		}
		con.desconectar();
		System.out.println("List alim ready..");
		return listaAlimentos;
	}
	
	// obtener por id
		public Alimento obtenerPorId(int id) throws SQLException {
			Alimento alimento = null;

			String sql = "SELECT * FROM alimento WHERE id_alimento= ? ";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet res = statement.executeQuery();
			if (res.next()) {
				alimento = new Alimento(res.getString("nombre"), res.getString("descripcion"), 
						res.getDouble("costo"), res.getInt("id_alimento"), res.getInt("id_categoria"));
			}
			res.close();
			con.desconectar();

			return alimento;
		}
		
		// actualizar alimento
		public boolean editarAlimento(Alimento alimento) throws SQLException {
			boolean rowActualizar = false;
			String sql = "UPDATE alimento SET id_categoria=?,nombre=?,descripcion=?, costo=? WHERE id_alimento=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, alimento.getIdCategoria());
			statement.setString(2, alimento.getNombre());
			statement.setString(3, alimento.getDescripcion());
			System.out.println(alimento.getCosto());
			statement.setDouble(4, alimento.getCosto());
			statement.setInt(5, alimento.getIdAlimento());
			System.out.println("Editado alim1");
			rowActualizar = statement.executeUpdate() > 0;
			System.out.println("Editado alim2");
			statement.close();
			con.desconectar();
			
			return rowActualizar;
		}
		
		//eliminar alimento
		public boolean eliminarAlimento(Alimento alimento) throws SQLException {
			boolean rowEliminar = false;
			String sql = "DELETE FROM alimento WHERE id_alimento=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, alimento.getIdAlimento());

			rowEliminar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();

			return rowEliminar;
		}
}

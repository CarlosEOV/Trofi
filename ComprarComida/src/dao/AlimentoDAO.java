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
			Alimento alimento = new Alimento(nombre, descripcion, costo, id);
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
						res.getDouble("costo"), res.getInt("id_alimento"));
			}
			res.close();
			con.desconectar();

			return alimento;
		}
}

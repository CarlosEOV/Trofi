package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Orden;
import modelo.Repartidor;
import modelo.Alimento;
import modelo.Cliente;
import modelo.Conexion;

public class OrdenDAO {
	private Conexion con;
	private Connection connection;
	

	public OrdenDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	// listar ordenes listas
	public List<Orden> listarOrdenesListas() throws SQLException {
		List<Orden> listaOrdenes = new ArrayList<Orden>();
		String sql = "SELECT * FROM orden WHERE estado_orden = 'LISTA'"; //"SELECT * FROM orden WHERE repartidor = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		
		while (resulSet.next()) {
			String correo_cliente = resulSet.getString("correo_e");
			int id_orden = resulSet.getInt("id_orden");
			String estado_orden = resulSet.getString("estado_orden");
			String direccion_cliente = resulSet.getString("direccion_cliente");
			String repartidor = resulSet.getString("repartidor");
			Orden orden = new Orden(correo_cliente,id_orden,estado_orden,direccion_cliente,repartidor);
			listaOrdenes.add(orden);
		}
		
		con.desconectar();
		return listaOrdenes;
	}
	
	// listar todas las ordenes.
		public List<Orden> listarOrdenes() throws SQLException {
			List<Orden> listaOrdenes = new ArrayList<Orden>();
			String sql = "SELECT * FROM orden WHERE estado_orden = 'PREPARANDO' ORDER BY correo_e"; //"SELECT * FROM orden WHERE repartidor = ?";
			con.conectar();
			connection = con.getJdbcConnection();
			Statement statement = connection.createStatement();
			ResultSet resulSet = statement.executeQuery(sql);
			
			while (resulSet.next()) {
				String correo_cliente = resulSet.getString("correo_e");
				int id_orden = resulSet.getInt("id_orden");
				String estado_orden = resulSet.getString("estado_orden");
				String direccion_cliente = resulSet.getString("direccion_cliente");
				String repartidor = resulSet.getString("repartidor");
				Orden orden = new Orden(correo_cliente,id_orden,estado_orden,direccion_cliente,repartidor);
				listaOrdenes.add(orden);
			}
			
			con.desconectar();
			return listaOrdenes;
		}
	
	public boolean crearOrden(List<Alimento> alimentos, String direccion, Cliente cliente) throws SQLException {
		return (agregarOrden(direccion, cliente) && agregarAlimentosOrden(alimentos,cliente));
	}
	
	public boolean agregarOrden(String direccion, Cliente cliente) throws SQLException{
		boolean agregar = false;
		String sql = "INSERT INTO orden (correo_e, estado_orden, direccion_cliente) VALUES (?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getCorreoE());
		statement.setString(2, "PREPARANDO");
		statement.setString(3, direccion);
		agregar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		System.out.println("ordenAgregada...");
		return agregar;
	}
	
	public boolean agregarAlimentosOrden(List<Alimento> alimentos, Cliente cliente) throws SQLException{
		int id_orden = getIdOrdenCliente(cliente);
		System.out.println("Agregando alimentos del pedido...");
		for(Alimento actual: alimentos) {
			if(!agregarAlimentoOrden(actual, cliente, id_orden)) { //Posible mal funcionamiento.
				System.out.println("Error... ");
				return false;
			}
			System.out.println("Agregando 1 alimento...");
			//agregarAlimentoOrden(actual, cliente, id_orden);
		}
		return true;
	}
	
	public boolean agregarAlimentoOrden(Alimento alimento, Cliente cliente, int id_orden) throws SQLException{
		boolean agregar = false;
		String sql = "INSERT INTO tener (correo_e, id_orden, id_categoria, id_alimento) VALUES (?, ?, ?, ?)";
		System.out.println("conectando... ");
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getCorreoE());
		statement.setInt(2, id_orden);
		statement.setInt(3, alimento.getIdCategoria());
		statement.setInt(4, alimento.getIdAlimento());
		agregar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		System.out.println("AlimentoAgregado...");
		return agregar;
	}
	
	public int getIdOrdenCliente(Cliente cliente) throws SQLException{
		int id_orden = -1;
		String sql = "SELECT MAX(id_orden) FROM orden WHERE correo_e = ?";
		System.out.println("BUSCANDO ID del pedido...");
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getCorreoE());
		
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			id_orden = res.getInt("MAX(id_orden)");
		}
		res.close();
		con.desconectar();
		System.out.println("id_orden: "+ id_orden);
		return id_orden;
	}
	
	public boolean asignarOrden(Repartidor repartidor,int id_orden, String correo) throws SQLException {
		boolean actualizar = false;
		String sql = "UPDATE orden SET repartidor= ? WHERE id_orden = ? AND correo_e = ?"; //ERROR: Falta considerar el correo CLIENTE
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, repartidor.getCorreo());
		statement.setInt(2, id_orden);
		statement.setString(3, correo);
		actualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return actualizar;
	}
	
	public boolean cambiarEstadoOrden(int id_orden, String opcion, String correo) throws SQLException {
		boolean actualizar = false;
		String sql = "UPDATE orden SET estado_orden= ? WHERE id_orden = ? AND correo_e= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, opcion);
		statement.setInt(2, id_orden);
		statement.setString(3, correo);
		actualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return actualizar;
	}
	
	public List<Orden> listarOrdenesAceptadas(Repartidor repartidor) throws SQLException {
		List<Orden> listaOrdenesAceptadas = new ArrayList<Orden>();
		String sql = "SELECT * FROM orden WHERE repartidor = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, repartidor.getCorreo());
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			String correo_cliente = resulSet.getString("correo_e");
			int id_ord = resulSet.getInt("id_orden");
			String estado_orden = resulSet.getString("estado_orden");
			String direccion_cliente = resulSet.getString("direccion_cliente");
			String rep = resulSet.getString("repartidor");
			Orden orden = new Orden(correo_cliente,id_ord,estado_orden,direccion_cliente,rep);
			listaOrdenesAceptadas.add(orden);
		}
		con.desconectar();
		return listaOrdenesAceptadas;
	}
	
	public List<Alimento> listaAlimentos(int id_orden, String correo) throws SQLException {
		List<Alimento> listaAlimento = new ArrayList<Alimento>();
		String sql = "SELECT * FROM alimento JOIN tener ON alimento.id_alimento = tener.id_alimento AND (tener.id_orden = ? AND tener.correo_e = ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_orden);
		statement.setString(2, correo);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			int id_alimento = resulSet.getInt("id_alimento");
			int id_categoria = resulSet.getInt("id_categoria");
			String nombre = resulSet.getString("nombre");
			String descripcion = resulSet.getString("descripcion");
			BigDecimal costo  = resulSet.getBigDecimal("costo");
			double d = costo.doubleValue();
			Alimento alimento = new Alimento(nombre,descripcion,d,id_alimento, id_categoria);
			listaAlimento.add(alimento);
		}
		con.desconectar();
		return listaAlimento;
	}
	
	public String verEstado(int orden) throws SQLException {
		String sql = "SELECT estado_orden FROM orden WHERE id_orden = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, orden);
		ResultSet resulSet = statement.executeQuery();
		resulSet.next();
		String estado = resulSet.getString("estado_orden");
		con.desconectar();
		return estado;
		
	}
	
}
	
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdenDAO;
import dao.RepartidorDAO;
import modelo.Alimento;
import modelo.Orden;
import modelo.Repartidor;


@WebServlet("/muestra_orden")
public class MuestraOrden extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrdenDAO ordenDAO;
	RepartidorDAO repartidorDAO;
	Repartidor repartidor;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try { 
			ordenDAO = new OrdenDAO(jdbcURL, jdbcUsername, jdbcPassword);
			repartidorDAO = new RepartidorDAO(jdbcURL, jdbcUsername, jdbcPassword);
			//repartidor = new Repartidor("erikRepartidor@gmail.com", "ErikRe", "QuinteroRe", "VilledaRe", "repartidor123");
		} catch (Exception e) { 
			
		}
	}
	
	public MuestraOrden() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola ...");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "cerrarSesion":
				cerrarSesion(request, response);
				break;
			case "verOrdenes":
				verOrdenes(request, response);
				break;
			case "verOrdenesAceptadas":
				verOrdenesAceptadas(request, response);
				break;
			case "verDetalles":
				verDetalles(request, response);
				break;
			case "cambiarEstado":
				cambiarEstado(request, response);
				break;
			case "aviso":
				aviso(request, response);
				break;
			case "asignaOrden":
				asignaOrden(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola ....");
		doGet(request, response);
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void verOrdenes(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String sesionRepartidor = request.getParameter("sesionRepartidor");
		if(sesionRepartidor != null) {
			repartidor = repartidorDAO.obtenerPorCorreo(sesionRepartidor);
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/Ordenes/ordenes.jsp");
		System.out.println("dispatcher ready..");
		List<Orden> listaordenes= ordenDAO.listarOrdenesListas();
		request.setAttribute("lista", listaordenes);
		System.out.println("regreso..");
		dispatcher.forward(request, response);
	}
	
	private void asignaOrden(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id_ord = Integer.parseInt(request.getParameter("id_orden"));
		String correoCliente = request.getParameter("correoCliente");
		ordenDAO.asignarOrden(repartidor, id_ord, correoCliente); 
		ordenDAO.cambiarEstadoOrden(id_ord, "EN CAMINO", correoCliente);
		String mensaje = "Orden asignada";
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/Ordenes/asigna.jsp");
		request.setAttribute("mensaje", mensaje);
		dispatcher.forward(request, response);
	}
	
	private void verOrdenesAceptadas(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//Repartidor repartidor = ordenDAO.getRepartidor();
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/Ordenes/ordenesAceptadas.jsp");
		List<Orden> listaordenesacept= ordenDAO.listarOrdenesAceptadas(repartidor);
		request.setAttribute("lista", listaordenesacept);
		dispatcher.forward(request, response);
	}
	
	private void verDetalles(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id_ord = Integer.parseInt(request.getParameter("id_orden"));
		String correoCliente = request.getParameter("correoCliente");
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/Ordenes/detalles.jsp");
		List<Alimento> alimentos= ordenDAO.listaAlimentos(id_ord, correoCliente);
		request.setAttribute("lista", alimentos);
		request.setAttribute("cliente", correoCliente);
		dispatcher.forward(request, response);
	}
	
	private void cambiarEstado(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id_ord = Integer.parseInt(request.getParameter("id_orden"));
		String correoCliente = request.getParameter("correoCliente");
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/Ordenes/estados.jsp");
		System.out.println("dispatcher ready..");
		List<String> estados = new ArrayList<String>();
		estados.add("ENTREGADA");
		estados.add("NO ENTREGADA");
		request.setAttribute("lista", estados);
		request.setAttribute("id_orden", id_ord);
		request.setAttribute("correoCliente", correoCliente);
		System.out.println("regreso..");
		dispatcher.forward(request, response);
	}
	
	private void aviso(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String aviso = "Estado cambiado";
		String nuevoEstado = request.getParameter("estado");
		String correoCliente = request.getParameter("correoCliente");
		int id_orden = Integer.parseInt(request.getParameter("id_orden"));
		ordenDAO.cambiarEstadoOrden(id_orden, nuevoEstado, correoCliente);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/Ordenes/aviso.jsp");
		request.setAttribute("mensaje", aviso);
		dispatcher.forward(request, response);
	}
	
	private void cerrarSesion (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		repartidor = null;
		RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	//az5459kHFr
}


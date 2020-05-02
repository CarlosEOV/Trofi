package controlador;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RepartidorDAO;
import modelo.Repartidor;

@WebServlet("/alta_repartidor")
public class Alta_Repartidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RepartidorDAO repartidorDAO;

	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try { 
			repartidorDAO = new RepartidorDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) { 
			
		}
	}
	
	public Alta_Repartidor() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola ...");
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevoRepartidor":
				nuevaCuenta(request, response);
				break;
			case "dardeAlta":
				darDeAlta(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	private void nuevaCuenta(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/Administrador/crearRepartidor.jsp");
		dispatcher.forward(request, response);
	}
	
	private void darDeAlta(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, NoSuchAlgorithmException {
		String[] symbols = {"0", "1", "2", "3","4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f","g","h","i","j","k","l","m","n","o","p","q"
		        ,"r","s","t","u","v","w","x","y","z","A", "B", "C", "D", "E", "F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		        int length = 10;
		        Random random = SecureRandom.getInstanceStrong();
		        StringBuilder sb = new StringBuilder(length);
		        for (int i = 0; i < length; i++) {
		            int indexRandom = random.nextInt(symbols.length);
		            sb.append(symbols[indexRandom]);
		        }
		        String password = sb.toString();
		Repartidor repartidor = new Repartidor(request.getParameter("correo_e"), request.getParameter("nombre"), request.getParameter("a_paterno"), request.getParameter("a_materno"), password);
		System.out.println(password);
		repartidorDAO.agregarCuenta(repartidor);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/Administrador/menu.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
}



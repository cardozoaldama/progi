package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ArticuloDAO;
import dao.CiudadDAO;
import dao.DepartamentoDAO;
import entidad.Ciudad;

@WebServlet("/obtenerCiudades")
public class ServletObtenerCiudades extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArticuloDAO articuloDAO;
	DepartamentoDAO departamentoDAO;
	CiudadDAO ciudadDAO;


	public void init() {
		String jdbcURL = getServletContext().getInitParameter("URL");
		String jdbcUsername = getServletContext().getInitParameter("USUARIO");
		String jdbcPassword = getServletContext().getInitParameter("CLAVE");
		try {

			articuloDAO = new ArticuloDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletObtenerCiudades() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDepartamentoParam = request.getParameter("idDepartamento");
        int idDepartamento = Integer.parseInt(idDepartamentoParam);

        // Obtener la lista de ciudades según el idDepartamento
        List<Ciudad> listaCiudades = null;
		try {
			listaCiudades = articuloDAO.listarCiudadesPorDepartamento(idDepartamento);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Convertir la lista de ciudades a JSON y enviarla como respuesta
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(listaCiudades));
        out.flush();
    }

}

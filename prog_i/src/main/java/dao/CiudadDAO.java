package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import entidad.Ciudad;

public class CiudadDAO {

	private Conexion con;
	private Connection connection;

	public CiudadDAO(String URL, String USUARIO, String CLAVE) throws SQLException {
		System.out.println(URL);
		con = new Conexion();
	}
	
	// listar las ciudades
	public List<Ciudad> listarCiudadesPorDepartamento(int idDepartamento) throws SQLException {
	    List<Ciudad> listaCiudades = new ArrayList<>();
	    String sql = "SELECT id_ciudad, id_departamento, nombre, observacion FROM ciudad WHERE id_departamento = ?";
	    
	    con.conectar();
		connection = con.getJdbcConnection();
    
	    PreparedStatement statement = connection.prepareStatement(sql);
	    statement.setInt(1, idDepartamento);
	    ResultSet resultSet = statement.executeQuery();

	    while (resultSet.next()) {
	        Integer idCiudad = resultSet.getInt("id_ciudad");
	        Integer id_Departamento = resultSet.getInt("id_departamento");
	        String nombre = resultSet.getString("nombre");
	        String observacion = resultSet.getString("observacion");
	        Ciudad ciudad = new Ciudad(idCiudad, id_Departamento, nombre, observacion);
	        listaCiudades.add(ciudad);
	    }
	    
	    // ... Cierra los recursos y la conexión a la base de datos ...
	    resultSet.close();
	    statement.close();
	    connection.close();

	    return listaCiudades;
	}


}

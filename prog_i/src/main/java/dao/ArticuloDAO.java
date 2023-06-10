package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import conexion.Conexion;
import entidad.Articulo;
import entidad.Ciudad;
import entidad.Departamento;

public class ArticuloDAO {
	private Conexion con;
	private Connection connection;

	public ArticuloDAO(String URL, String USUARIO, String CLAVE) throws SQLException {
		System.out.println(URL);
		con = new Conexion();
	}
	
	//private static final AtomicLong contadorid = new AtomicLong(104);//contador que ira incrementando el valor del ID el cual genera automaticamente
	private AtomicInteger contadorid = new AtomicInteger(0);
	private String activoS = "S";
	private String inactivoN = "N";
	Long datetime = System.currentTimeMillis(); //Para obtener fecha-hora actual del sistema operativo
	Timestamp timestamp = new Timestamp(datetime);
	
	
	// insertar artículo
	public boolean insertar(Articulo articulo, HttpServletRequest request) throws SQLException {
		String sql = "INSERT INTO articulos (idarticulo, codigo, nombre, descripcion, existencia, precio, activo, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//Contador para insertar el ID
		int ultimoIdArticulo = obtenerUltimoIdArticulo();
		contadorid.set(ultimoIdArticulo + 1);
		
		statement.setInt(1, contadorid.get());
		statement.setString(2, articulo.getCodigo());
		statement.setString(3, articulo.getNombre());
		statement.setString(4, articulo.getDescripcion());
		statement.setDouble(5, articulo.getExistencia());
		statement.setDouble(6, articulo.getPrecio());
		statement.setString(7, activoS);
		
		//Para obtener e insertar el usuario de sesión
	    String usuarioCreacion = request.getParameter("nombre");
	    statement.setString(8, usuarioCreacion);

		statement.setTimestamp(9, timestamp);
		
		//Para obtener e insertar el usuario de sesión
	    String usuarioModificacion = request.getParameter("nombre");
		statement.setString(10, usuarioModificacion);
		
		statement.setTimestamp(11, timestamp);
		
		boolean rowInserted = statement.executeUpdate() > 0;
		System.out.println("Articulo registrado");
		statement.close();
		con.desconectar();
		return rowInserted;
        
	}
	
	public int obtenerUltimoIdArticulo() throws SQLException {
	    String sql = "SELECT MAX(idarticulo) FROM articulos";
	    try (Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql)) {
	        if (resultSet.next()) {
	            return resultSet.getInt(1);
	        }
	    }
	    // Si no hay registros en la tabla, retorna un valor predeterminado
	    return 0;
	}

	// listar todos los productos
	public List<Articulo> listarArticulos() throws SQLException {

		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos where activo = 'S'";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int idarticulo = resulSet.getInt("idarticulo");
			String codigo = resulSet.getString("codigo");
			String nombre = resulSet.getString("nombre");
			String descripcion = resulSet.getString("descripcion");
			Double existencia = resulSet.getDouble("existencia");
			Double precio = resulSet.getDouble("precio");
			Articulo articulo = new Articulo(idarticulo, codigo, nombre, descripcion, existencia, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}

	// obtener por id
	public Articulo obtenerPorId(int idarticulo) throws SQLException {
		Articulo articulo = null;

		String sql = "SELECT * FROM articulos WHERE idarticulo= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idarticulo);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			articulo = new Articulo(res.getInt("idarticulo"), res.getString("codigo"), res.getString("nombre"),
					res.getString("descripcion"), res.getDouble("existencia"), res.getDouble("precio"));
		}
		res.close();
		con.desconectar();

		return articulo;
	}
	
	// actualizar
	public boolean actualizar(Articulo articulo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE articulos SET codigo=?,nombre=?,descripcion=?,existencia=?, precio=? WHERE idarticulo=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, articulo.getCodigo());
		statement.setString(2, articulo.getNombre());
		statement.setString(3, articulo.getDescripcion());
		statement.setDouble(4, articulo.getExistencia());
		System.out.println(articulo.getPrecio());
		statement.setDouble(5, articulo.getPrecio());
		statement.setInt(6, articulo.getIdarticulo());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	public boolean actualizarArticulo(Articulo articulo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE articulos SET codigo=?,nombre=?,descripcion=?,existencia=?, precio=?, usuario_modificacion=?, fecha_modificacion=? WHERE idarticulo=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, articulo.getCodigo());
		statement.setString(2, articulo.getNombre());
		statement.setString(3, articulo.getDescripcion());
		statement.setDouble(4, articulo.getExistencia());
		System.out.println(articulo.getPrecio());
		statement.setDouble(5, articulo.getPrecio());
		statement.setInt(6, articulo.getIdarticulo());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Articulo articulo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM articulos WHERE idarticulo=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		//statement.setInt(1, articulo.getIdarticulo());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
	
	public boolean actualizarInactivar(Articulo articulo, HttpServletRequest request) throws SQLException {
		boolean rowInactivar = false;
		String sql = "UPDATE articulos SET activo=?, usuario_modificacion=?, fecha_modificacion=? WHERE idarticulo=?";;
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, inactivoN);
		String usuarioModificacion = request.getParameter("nombre");
		statement.setString(2, usuarioModificacion);
		statement.setTimestamp(3, timestamp);
		statement.setInt(4, articulo.getIdarticulo());

		rowInactivar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowInactivar;
	}
	
	// listar los departamentos
			public List<Departamento> listarDepartamentos() throws SQLException {

				List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
				String sql = "SELECT id_departamento, nombre, observacion FROM departamento where activo='S' ";
				con.conectar();
				connection = con.getJdbcConnection();
				Statement statement = connection.createStatement();
				ResultSet resulSet = statement.executeQuery(sql);

				while (resulSet.next()) {
					Integer iddepartamento = resulSet.getInt("id_departamento");
					String nombre = resulSet.getString("nombre");
					String observacion = resulSet.getString("observacion");
					Departamento departamento = new Departamento(iddepartamento, nombre, observacion);
					listaDepartamentos.add(departamento);
				}
				con.desconectar();
				return listaDepartamentos;
			}
			
		// listar las ciudades
			public List<Ciudad> listarCiudades() throws SQLException {

				List<Ciudad> listarCiudades = new ArrayList<Ciudad>();
				String sql = "SELECT id_ciudad, id_departamento, nombre, observacion FROM ciudad";
				con.conectar();
				connection = con.getJdbcConnection();
				Statement statement = connection.createStatement();
				ResultSet resulSet = statement.executeQuery(sql);

				while (resulSet.next()) {
					Integer idciudad = resulSet.getInt("id_ciudad");
					Integer iddepartamento = resulSet.getInt("id_departamento");
					String nombre = resulSet.getString("nombre");
					String observacion = resulSet.getString("observacion");
					Ciudad ciudad = new Ciudad(idciudad, iddepartamento, nombre, observacion);
					listarCiudades.add(ciudad);
				}
				con.desconectar();
				return listarCiudades;
			}
			
			
			public List<Ciudad> listarCiudadesPorDepartamento(int idDepartamento) throws SQLException {
			    List<Ciudad> listaCiudades = new ArrayList<>();
			    String sql = "SELECT id_ciudad, id_departamento, nombre, observacion FROM ciudad WHERE id_departamento = ?";
			    // ... Realiza la conexión a la base de datos (si aún no lo has hecho) ...
			    con.conectar();
				connection = con.getJdbcConnection();
			    PreparedStatement statement = connection.prepareStatement(sql);
			    statement.setInt(1, idDepartamento);
			    ResultSet resultSet = statement.executeQuery();

			    while (resultSet.next()) {
			        Integer id_ciudad = resultSet.getInt("id_ciudad");
			        Integer id_departamento = resultSet.getInt("id_departamento");
			        String nombre = resultSet.getString("nombre");
			        String observacion = resultSet.getString("observacion");
			        Ciudad ciudad = new Ciudad(id_ciudad, id_departamento, nombre, observacion);
			        listaCiudades.add(ciudad);
			    }
			    // ... Cierra los recursos y la conexión a la base de datos ...

			    con.desconectar();
			    return listaCiudades;
			}

			
}
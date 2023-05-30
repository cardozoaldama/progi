package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import conexion.Conexion;
import entidad.Articulo;

public class ArticuloDAO {
	private Conexion con;
	private Connection connection;

	public ArticuloDAO(String URL, String USUARIO, String CLAVE) throws SQLException {
		System.out.println(URL);
		con = new Conexion();
	}
	
	private static final AtomicLong contadorid = new AtomicLong(100); //contador que ira incrementando el valor del ID el cual genera automaticamente
	private String activoS = "S";
	private String inactivoN = "N";
	Long datetime = System.currentTimeMillis(); //Para obtener fecha-hora actual del sistema operativo
	Timestamp timestamp = new Timestamp(datetime);
	
	// insertar artículo
	public boolean insertar(Articulo articulo) throws SQLException {
		String sql = "INSERT INTO articulos (idarticulo, codigo, nombre, descripcion, existencia, precio, activo, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(articulo.getDescripcion());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, (int) contadorid.incrementAndGet());
		statement.setString(2, articulo.getCodigo());
		statement.setString(3, articulo.getNombre());
		statement.setString(4, articulo.getDescripcion());
		statement.setDouble(5, articulo.getExistencia());
		statement.setDouble(6, articulo.getPrecio());
		statement.setString(7, activoS);
		statement.setString(8, null);
		statement.setTimestamp(9, timestamp);
		statement.setString(10, null);
		statement.setTimestamp(11, timestamp);
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Articulo> listarArticulos() throws SQLException {

		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos";
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
			String activo = resulSet.getString("activo");
			String usuarioCreacion = resulSet.getString("usuarioCreacion");
			Timestamp fechaHoraCreacion = resulSet.getTimestamp("fechaHoraCreacion");
			String usuarioModificacion = resulSet.getString("usuarioModificacion");
			Timestamp fechaHoraModificacion = resulSet.getTimestamp("fechaHoraModificacion");
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
	
	//eliminar
	public boolean eliminar(Articulo articulo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM articulos WHERE idarticulo=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, articulo.getIdarticulo());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
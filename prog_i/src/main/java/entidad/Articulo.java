package entidad;

public class Articulo {	
	
	private int idarticulo;
	private String codigo;
	private String nombre;
	private String descripcion;
	private double existencia;
	private double precio;
	/*
	 * private String activo; private String usuarioCreacion; private Timestamp
	 * fechaHoraCreacion; private String usuarioModificacion; private Timestamp
	 * fechaHoraModificacion;
	 */
	
	public Articulo(int idarticulo, String codigo, String nombre, String descripcion, double existencia, double precio) {
		this.idarticulo = idarticulo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.existencia = existencia;
		this.precio = precio;
		/*
		 * this.usuarioCreacion = usuarioCreacion; this.fechaHoraCreacion =
		 * fechaHoraCreacion; this.usuarioModificacion = usuarioModificacion;
		 * this.fechaHoraModificacion = fechaHoraModificacion;
		 */
	}
	//getters y setters

	public String getCodigo() {
		return codigo;
	}
	
	public int getIdarticulo() {
		return idarticulo;
	}


	public void setIdarticulo(int idarticulo) {
		this.idarticulo = idarticulo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getExistencia() {
		return existencia;
	}
	public void setExistencia(double existencia) {
		this.existencia = existencia;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/*
	 * public String getActivo() { return activo; }
	 * 
	 * public void setActivo(String activo) { this.activo = activo; }
	 * 
	 * public String getUsuarioCreacion() { return usuarioCreacion; }
	 * 
	 * public void setUsuarioCreacion(String usuarioCreacion) { this.usuarioCreacion
	 * = usuarioCreacion; }
	 * 
	 * public Timestamp getFechaHoraCreacion() { return fechaHoraCreacion; }
	 * 
	 * public void setFechaHoraCreacion(Timestamp fechaHoraCreacion) {
	 * this.fechaHoraCreacion = fechaHoraCreacion; }
	 * 
	 * public String getUsuarioModificacion() { return usuarioModificacion; }
	 * 
	 * public void setUsuarioModificacion(String usuarioModificacion) {
	 * this.usuarioModificacion = usuarioModificacion; }
	 * 
	 * public Timestamp getFechaHoraModificacion() { return fechaHoraModificacion; }
	 * 
	 * public void setFechaHoraModificacion(Timestamp fechaHoraModificacion) {
	 * this.fechaHoraModificacion = fechaHoraModificacion; }
	 */
}

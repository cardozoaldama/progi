package entidad;

public class Articulo {
	private int idarticulo;
	private String codigo;
	private String nombre;
	private String descripcion;
	private double existencia;
	private double precio;

	public Articulo(int idarticulo, String codigo, String nombre, String descripcion, double existencia,
			double precio) {
		this.idarticulo = idarticulo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.existencia = existencia;
		this.precio = precio;
	}
	// getters y setters

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
}

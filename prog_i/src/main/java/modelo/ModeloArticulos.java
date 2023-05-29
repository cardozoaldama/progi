package modelo;

import java.util.concurrent.atomic.AtomicLong;

public class ModeloArticulos {

	private int idarticulo;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Double existencia;
	private Double precio;
	private static final AtomicLong contador = new AtomicLong(100);

	public ModeloArticulos(int idarticulo, String codigo, String nombre, String descripcion, Double existencia, Double precio) {
		this.idarticulo = idarticulo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.existencia = existencia;
		this.precio = precio;
	}

	public ModeloArticulos(String codigo, String nombre, String descripcion, Double existencia, Double precio) {
		this.idarticulo = (int) contador.incrementAndGet();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.existencia = existencia;
		this.precio = precio;
	}

	public int getIdarticulo() {
		return idarticulo;
	}

	public void setIdarticulo(int idarticulo) {
		this.idarticulo = idarticulo;
	}

	public String getCodigo() {
		return codigo;
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

	public Double getExistencia() {
		return existencia;
	}

	public void setExistencia(Double existencia) {
		this.existencia = existencia;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	

}

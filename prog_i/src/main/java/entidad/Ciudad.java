package entidad;

public class Ciudad {
	
	private Integer id_ciudad;
	private Integer id_departamento;
	private String nombre;
	private String observacion;
	
	public Ciudad(int id_ciudad,int id_departamento,String nombre, String observacion) {
		this.id_ciudad = id_ciudad;
		this.id_departamento = id_departamento;
		this.nombre = nombre;
		this.observacion = observacion;
	}

	public Integer getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Integer id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public Integer getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Integer id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	
}

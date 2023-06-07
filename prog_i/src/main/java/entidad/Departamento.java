package entidad;

public class Departamento {	
	private Integer id_departamento;
	private String nombre;
	private String observacion;
	
	public Departamento(int id_departamento,String nombre, String observacion) {
		this.id_departamento = id_departamento;
		this.nombre = nombre;
		this.observacion = observacion;
	}
	//getters y setters

	public Departamento(Integer id) {
		this.id_departamento = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_departamento == null) ? 0 : id_departamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id_departamento == null) {
			if (other.id_departamento != null)
				return false;
		} else if (!id_departamento.equals(other.id_departamento))
			return false;
		return true;
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
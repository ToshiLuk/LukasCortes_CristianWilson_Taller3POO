package dominio;

public abstract class Tarea {
	protected String idProyecto;
	protected String id;
	protected String descripcion;
	protected String prioridad;
	protected String estado;
	protected String responsable;
	protected String complejidad;
	protected String fecha;
	
	public Tarea(String idProyecto, String id, String descripcion, String prioridad, String estado, String responsable) {
		this.idProyecto = idProyecto;
		this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.responsable = responsable;
        this.complejidad = complejidad;
        this.fecha = fecha;
    }
	
	public abstract void accept(IVisitor visitor);
    
    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public String getComplejidad() {
		return complejidad;
	}

	public String getFecha() {
		return fecha;
	}
	
	public String getIdProyecto() {
		return idProyecto;
	}

	public String getResponsable() {
		return responsable;
	}

	@Override
    public String toString() { 
		return id + " | " + descripcion + " | " + estado + " | " + complejidad; 
	}
}


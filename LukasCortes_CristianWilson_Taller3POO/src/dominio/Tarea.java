package dominio;

public abstract class Tarea {
	private String id;
	private String descripcion;
	private String estado;
	private String responsable;
	private String complejidad;
	private String fecha;
	
	public Tarea(String id, String descripcion, String estado, String responsable, String complejidad, String fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.responsable = responsable;
        this.complejidad = complejidad;
        this.fecha = fecha;
    }
	
	public abstract void accept(IVisitor visitor);
	
}

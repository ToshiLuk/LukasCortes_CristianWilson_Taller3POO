package dominio;

import java.time.LocalDate;

public abstract class Tarea {
    protected String idProyecto;
    protected String id;
    protected String descripcion;
    protected String estado;
    protected String responsable;
    protected String complejidad;
    protected LocalDate fecha;
    
    public Tarea(String idProyecto, String id, String descripcion, String estado, String responsable, String complejidad, LocalDate fecha) {
        this.idProyecto = idProyecto;
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.responsable = responsable;
        this.complejidad = complejidad;
        this.fecha = fecha;
    }
    
    public abstract void accept(IVisitor visitor);
    
    // Getters y Setters
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
    public LocalDate getFecha() { 
    	
    	return fecha; 
    	}
    public String getIdProyecto() { 
    	
    	return idProyecto; 
    	}
    public String getResponsable() { 
    	
    	return responsable; 
    	
    	}
    
    public String getDescripcion() {
    	
    	return descripcion; 
    	
    	}

    @Override
    public String toString() { 
        return id + " | " + descripcion + " | " + estado + " | " + complejidad; 
    }
}

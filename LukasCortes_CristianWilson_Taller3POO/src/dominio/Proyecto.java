package dominio;

import java.util.ArrayList;
import java.util.List;

import estrategias.IEstrategiaOrdenamiento;

public class Proyecto {
	
	private String id;
    private String nombre;
    private String responsable; 
    private List<Tarea> tareas;

    public Proyecto(String id, String nombre, String responsable) {
        this.id = id;
        this.nombre = nombre;
        this.responsable = responsable;
        this.tareas = new ArrayList<>();
    }
    

    public void agregarTarea(Tarea tarea) {
        this.tareas.add(tarea);
    }

    public String getId() { 
    		return id; 
    	}
    public String getNombre() { 
    		return nombre; 
    	}
    public List<Tarea> getTareas() { 
    		return tareas; 
    	}
	public String getResponsable() {
		return responsable;
	}
    
	public void ordenarTareas(IEstrategiaOrdenamiento estrategia) {
	    estrategia.ordenar(this.tareas);
	}

}

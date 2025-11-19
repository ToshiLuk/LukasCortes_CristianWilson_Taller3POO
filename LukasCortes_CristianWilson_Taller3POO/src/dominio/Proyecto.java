package dominio;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	
	private String id;
    private String nombre;
    private String responsable; // Username del admin responsable
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

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Tarea> getTareas() { return tareas; }

}

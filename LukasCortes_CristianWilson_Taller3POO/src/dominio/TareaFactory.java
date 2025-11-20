package dominio;

import java.time.LocalDate;

public class TareaFactory {
    public static Tarea crearTarea(String tipo, String idProyecto, String id, 
                                   String desc, String estado, String resp, 
                                   String comp, LocalDate fecha) {
        
        // Normalizamos a minúsculas para evitar errores (Bug vs bug)
        switch (tipo.trim().toLowerCase()) {
            case "bug":
                return new Bug(idProyecto, id, desc, estado, resp, comp, fecha);
            case "feature":
                return new Feature(idProyecto, id, desc, estado, resp, comp, fecha);
            case "documentacion":
                return new Documentacion(idProyecto, id, desc, estado, resp, comp, fecha);
            default:
                throw new IllegalArgumentException("Tipo de tarea desconocido: " + tipo);
        }
    }
}

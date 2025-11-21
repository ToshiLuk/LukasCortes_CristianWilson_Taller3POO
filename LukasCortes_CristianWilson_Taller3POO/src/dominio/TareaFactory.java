package dominio;
import java.time.LocalDate;

public class TareaFactory {
    public static Tarea crearTarea(String tipo, String idProj, String id, String desc, String est, String resp, String comp, LocalDate fecha) {
        switch (tipo.trim().toLowerCase()) {
            case "bug":
                return new Bug(idProj, id, desc, est, resp, comp, fecha);
            case "feature":
                return new Feature(idProj, id, desc, est, resp, comp, fecha);
            case "documentacion":
                return new Documentacion(idProj, id, desc, est, resp, comp, fecha);
            default:
                throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }
}
package dominio;

public class TareaFactory {
	
	public static Tarea crearTarea(String tipo, String id, String desc, String estado, String resp, String comp, String fecha) {
        switch (tipo.trim()) {
            case "Bug":
                return new Bug(id, desc, estado, resp, comp, fecha);
            case "Feature":
                return new Feature(id, desc, estado, resp, comp, fecha);
            case "Documentacion":
                return new Documentacion(id, desc, estado, resp, comp, fecha);
            default:
                return null; // O lanzar una excepción
        }
    }
}

package dominio;

import java.time.LocalDate;

public class Bug extends Tarea {
	
	

    public Bug(String idProyecto, String id, String descripcion, String prioridad, String complejidad,  String estado, String responsable, LocalDate fecha) {
		super(idProyecto, id, descripcion, estado, responsable, complejidad, fecha);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

}

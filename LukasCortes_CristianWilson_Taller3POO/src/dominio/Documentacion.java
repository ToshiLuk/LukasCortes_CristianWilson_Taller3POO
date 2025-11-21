package dominio;

import java.time.LocalDate;

public class Documentacion extends Tarea {
	

	public Documentacion(String idProyecto, String id, String descripcion, String estado, String responsable, String complejidad, LocalDate fecha) {
        super(idProyecto, id, descripcion, estado, responsable, complejidad, fecha);
    }

	@Override
	public void accept(IVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}

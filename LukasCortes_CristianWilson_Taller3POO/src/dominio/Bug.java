package dominio;

public class Bug extends Tarea {
	
	

    public Bug(String idProyecto, String id, String descripcion, String prioridad, String estado, String responsable) {
		super(idProyecto, id, descripcion, prioridad, estado, responsable);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void accept(IVisitor visitor) {
        visitor.visit(this); // Esto activa el visitor específico para Bug
    }

}

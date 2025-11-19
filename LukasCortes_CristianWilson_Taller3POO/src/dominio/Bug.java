package dominio;

public class Bug extends Tarea {
	
	public Bug(String id, String descripcion, String estado, String responsable, String complejidad, String fecha) {
        super(id, descripcion, estado, responsable, complejidad, fecha);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this); // Esto activa el visitor específico para Bug
    }

}

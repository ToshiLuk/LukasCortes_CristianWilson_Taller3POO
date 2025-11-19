package dominio;

public class Documentacion extends Tarea {
	public Documentacion(String id, String descripcion, String estado, String responsable, String complejidad, String fecha) {
        super(id, descripcion, estado, responsable, complejidad, fecha);
    }

	@Override
	public void accept(IVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}

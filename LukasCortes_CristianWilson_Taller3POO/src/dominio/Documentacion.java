package dominio;

public class Documentacion extends Tarea {
	

	public Documentacion(String idProyecto, String id, String descripcion, String prioridad, String estado,
			String responsable) {
		super(idProyecto, id, descripcion, prioridad, estado, responsable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(IVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}

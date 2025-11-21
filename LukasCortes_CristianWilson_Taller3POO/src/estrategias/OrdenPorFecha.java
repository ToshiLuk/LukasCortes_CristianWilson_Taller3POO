package estrategias;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import dominio.Tarea;

public class OrdenPorFecha implements IEstrategiaOrdenamiento {
    @Override
    public void ordenar(List<Tarea> tareas) {
        
        Collections.sort(tareas, Comparator.comparing(Tarea::getFecha));
        System.out.println("--- Tareas ordenadas por Fecha (Antiguas -> Nuevas) ---");
    }
}
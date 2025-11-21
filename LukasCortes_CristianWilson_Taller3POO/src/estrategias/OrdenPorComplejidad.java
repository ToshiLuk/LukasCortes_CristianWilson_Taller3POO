package estrategias;

import java.util.Collections;
import java.util.List;
import dominio.Tarea;

public class OrdenPorComplejidad implements IEstrategiaOrdenamiento {
    @Override
    public void ordenar(List<Tarea> tareas) {
        Collections.sort(tareas, (t1, t2) -> {
            return getPeso(t1.getComplejidad()) - getPeso(t2.getComplejidad());
        });
        System.out.println("--- Tareas ordenadas por Complejidad (Alta > Media > Baja) ---");
    }

    private int getPeso(String complejidad) {
        if (complejidad == null) return 99;
        
        // Normalizamos a minúsculas por si acaso
        switch (complejidad.trim().toLowerCase()) {
            case "alta": return 1;
            case "media": return 2;
            case "baja": return 3;
            default: return 4;
        }
    }
}

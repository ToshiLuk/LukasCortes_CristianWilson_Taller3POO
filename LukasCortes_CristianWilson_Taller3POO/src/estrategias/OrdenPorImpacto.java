package estrategias;

import java.util.Collections;
import java.util.List;
import dominio.*;

public class OrdenPorImpacto implements IEstrategiaOrdenamiento {
	
    public void ordenar(List<Tarea> tareas) {
        Collections.sort(tareas, (t1, t2) -> {
            return getPeso(t1) - getPeso(t2);
        });
        System.out.println("--- Tareas ordenadas por Impacto (Bug > Feature > Doc) ---");
    }

    private int getPeso(Tarea t) {
        
        if (t instanceof Bug) return 1;
        if (t instanceof Feature) return 2;
        if (t instanceof Documentacion) return 3;
        return 4;
    }
}

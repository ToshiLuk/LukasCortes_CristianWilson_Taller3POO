package dominio;

public class AnalisisVisitor implements IVisitor {
    @Override
    public void visit(Bug bug) {
        System.out.println(">> [Visitor] Bug detectado: Afecta la estabilidad crítica.");
    }
    @Override
    public void visit(Feature feature) {
        System.out.println(">> [Visitor] Feature detectada: Validar estimación de tiempos.");
    }
    @Override
    public void visit(Documentacion doc) {
        System.out.println(">> [Visitor] Documentación: Revisar ortografía y exportar.");
    }
}

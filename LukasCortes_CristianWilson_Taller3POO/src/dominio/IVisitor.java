package dominio;

public interface IVisitor {
	void visit(Bug bug);
    void visit(Feature feature);
    void visit(Documentacion documentacion);
}

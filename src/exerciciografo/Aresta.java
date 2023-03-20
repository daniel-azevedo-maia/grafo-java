package exerciciografo;

import java.util.List;

public class Aresta {

	/*
	 * private List<Vertice> vertices;
	 * 
	 * public List<Vertice> getVertices() { return vertices; }
	 * 
	 * public void setVertices(List<Vertice> vertices) { this.vertices = vertices; }
	 * 
	 * @Override public String toString() { return "Aresta " + vertices + "]"; }
	 * 
	 */
	private Vertice origem;
	private Vertice destino;

	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}

	public Vertice getDestino() {
		return destino;
	}

	public void setDestino(Vertice destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "" + origem + destino + "";
	}
	
	

}

package exerciciografo;

import java.util.List;

public class Grafo {

	private List<Aresta> arestas;
	private List<Vertice> vertices;

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice> vertices) {
		this.vertices = vertices;
	}

	@Override
	public String toString() {
		return "Grafo --> {E: " + arestas + " | V: " + vertices + "}";
	}

	public boolean verificarTipo() {
		for (int i = 0; i < arestas.size(); i++) {

			Aresta sentidoContrario = new Aresta();
			sentidoContrario.setOrigem(arestas.get(i).getDestino());
			sentidoContrario.setDestino(arestas.get(i).getOrigem());

			if (arestas.toString().contains(sentidoContrario.toString())) {
				System.out.println(arestas.get(i).toString() + " e " + sentidoContrario.toString());
				return false;
			}

		}
		return true;

	}
}

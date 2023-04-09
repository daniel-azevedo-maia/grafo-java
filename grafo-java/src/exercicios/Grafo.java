package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Grafo {
	
	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;
	private boolean isDigrafo; // verifica se é grafo direcionado ou não.
	private int ordem; // Número de vértices do grafo.
	private int tamanho; // Número de arestas do grafo.

	public Grafo(boolean isDigrafo) {
		vertices = new ArrayList<>();
		arestas = new ArrayList<>();
		this.isDigrafo = isDigrafo;
	}

	public Grafo() {
		vertices = new ArrayList<>();
		arestas = new ArrayList<>();
	}

	public void addVertice(Vertice vertice) {
		vertices.add(vertice);
		ordem++;
	}

	public void addAresta(Aresta aresta) {
		arestas.add(aresta);
		tamanho++;
		if (isDigrafo) {
			aresta.getOrigem().setGrauOut(aresta.getOrigem().getGrauOut() + 1);
			aresta.getDestino().setGrauIn(aresta.getDestino().getGrauIn() + 1);
		} else {
			aresta.getOrigem().setGrau(aresta.getOrigem().getGrau() + 1);
			aresta.getDestino().setGrau(aresta.getDestino().getGrau() + 1);
		}
	}

	public boolean descobreSeDigrafo() {
		for (Aresta a : arestas) { // for-each
			if (a.getOrigem() == a.getDestino()) {
				System.out.println("É Digrafo");
				isDigrafo = true;
				return true;
			}
			for (Aresta b : arestas) {
				if (a != b && a.getOrigem() == b.getDestino() && a.getDestino() == b.getOrigem()) {
					System.out.println("É digrafo");
					isDigrafo = true;
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		StringBuilder infoGrafo = new StringBuilder();

		if (isDigrafo) {
			infoGrafo.append("Dígrafo -> Vértices:\n");
			for (Vertice vertice : vertices) {
				infoGrafo.append("\n").append(vertice.getNome()).append(" (grauIn: ").append(vertice.getGrauIn())
						.append(", grauOut: ").append(vertice.getGrauOut()).append(")");
			}
		} else {
			infoGrafo.append("Grafo Ñ direcionado -> Vértices:\n");
			infoGrafo.append(
					vertices.stream().map(vertice -> "\n" + vertice.getNome() + " (grau: " + vertice.getGrau() + ")")
							.collect(Collectors.joining()));
		}
		infoGrafo.append("\n\nArestas: ").append(arestas);
		return infoGrafo.toString();
	}

	public List<Vertice> obtemAdjacencias(Vertice vertice) {
		ArrayList<Vertice> adjacencias = new ArrayList<>();
		for (Aresta aresta : arestas) {
			if (aresta.getDestino() == vertice && !adjacencias.contains(aresta.getOrigem()))
				adjacencias.add(aresta.getOrigem());
			if (!isDigrafo && aresta.getOrigem() == vertice && !adjacencias.contains(aresta.getDestino()))
				adjacencias.add(aresta.getDestino());
		}
		return adjacencias;
	}

	// Implementação das matrizes de adjacência e incidência

	public int[][] criaMatrizAdjacencia() {
		
		int[][] matrizAdjacencia = new int[ordem][ordem];

		for (Aresta aresta : arestas) {
			int origem = Integer.parseInt(aresta.getOrigem().getNome()) - 1;
			// Subtraímos 1 porque os índices da matriz começam em 0 e os nomes dos vértices
			// começam em 1.
			int destino = Integer.parseInt(aresta.getDestino().getNome()) - 1;
			matrizAdjacencia[origem][destino] = 1;
			if (!isDigrafo) {
				matrizAdjacencia[destino][origem] = 1;
			}

		}

		return matrizAdjacencia;

	}

	public int[][] criaMatrizIncidencia() {
		int[][] matrizIncidencia = new int[ordem][tamanho];

		for (int i = 0; i < arestas.size(); i++) {
			Aresta aresta = arestas.get(i);
			int origem = Integer.parseInt(aresta.getOrigem().getNome()) - 1;
			int destino = Integer.parseInt(aresta.getDestino().getNome()) - 1;
			matrizIncidencia[origem][i] = isDigrafo ? -1 : 1;
			matrizIncidencia[destino][i] = 1;
		}
		return matrizIncidencia;
	}

	public void imprimeMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
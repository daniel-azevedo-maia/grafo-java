package exerciciografo;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		// Verificar se é direcionado ou não.

		Vertice v1 = new Vertice();
		v1.setNome("A");

		Vertice v2 = new Vertice();
		v2.setNome("B");

		Vertice v3 = new Vertice();
		v3.setNome("C");

		Vertice v4 = new Vertice();
		v4.setNome("D");
	

		Aresta a1 = new Aresta();
		a1.setOrigem(v1);
		a1.setDestino(v2);

		Aresta a2 = new Aresta();
		a2.setOrigem(v2);
		a2.setDestino(v3);

		Aresta a3 = new Aresta();
		a3.setOrigem(v3);
		a3.setDestino(v4);

		Aresta a4 = new Aresta();
		a4.setOrigem(v4);
		a4.setDestino(v1);
		
		Aresta a5 = new Aresta();
		a5.setOrigem(v1);
		a5.setDestino(v4);

		Grafo grafo = new Grafo();
		grafo.setVertices(Arrays.asList(v1, v2, v3, v4));
		grafo.setArestas(Arrays.asList(a1, a2, a3, a4, a5));
		
		System.out.println(grafo);
		
		boolean direcionado = grafo.verificarTipo();
		if (!direcionado) {
			System.out.println("É um grafo direcionado.");
		} else {
			System.out.println("Não é um grafo direcionado.");
		}
	
	}

}

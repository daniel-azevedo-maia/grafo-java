package exercicios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vertice {
	
	private String nome;
	private int grau; // nº de arestas que incidem no vértice (casos de grafo não direcionado)
	private int grauIn; // grau de entrada do vértice em um dígrafo (grafo direcionado)
	private int grauOut; // grau de saída do vértice em um dígrafo (grafo direcionado)

	public Vertice(String nome){
		this.nome = nome;
	}

	public String toString(){
		return nome + " (grau: " + grau + ")";
	}
}

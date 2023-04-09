package exercicios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vertice {
	
	private String nome;
	private int grau; // n� de arestas que incidem no v�rtice (casos de grafo n�o direcionado)
	private int grauIn; // grau de entrada do v�rtice em um d�grafo (grafo direcionado)
	private int grauOut; // grau de sa�da do v�rtice em um d�grafo (grafo direcionado)

	public Vertice(String nome){
		this.nome = nome;
	}

	public String toString(){
		return nome + " (grau: " + grau + ")";
	}
}

package exerciciografo01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Aresta {
	private Vertice origem;
	private Vertice destino;

	public String toString(){
		return "("+ origem.getNome() + "," + destino.getNome() + ")";
	}
}
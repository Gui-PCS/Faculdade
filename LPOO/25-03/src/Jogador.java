
public class Jogador {
	private String nome;
	private int pontos;
	
	public Jogador(String nome) {
		this.nome = nome;
		this.pontos = 0;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getPontos() {
		return this.pontos;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	@Override
	public String toString() {
		return "O jogardor "+this.nome+" marcou "+this.pontos+" pontos";
	}
}

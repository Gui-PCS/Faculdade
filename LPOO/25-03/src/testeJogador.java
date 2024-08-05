import java.util.ArrayList;

public class testeJogador {
	public static void main(String[] args) {
		Jogador j = new Jogador("josé");
		System.out.println("normal: "+j);
		
		aumentaPonto(j.getPontos(), 50);
		System.out.println("aumentaPonto: "+j);
		
		aumentaPontoJogador(j, 50);
		System.out.println("aumentaPontoJogador: "+j);
		
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(j);
		
		aumentaPontosJogadores(jogadores, 50);
		System.out.println("aumentaPontosJogadores: "+j);
	}
	
	public static void aumentaPonto(int pontoDoJogador, int qtdPontos) {
		pontoDoJogador+=qtdPontos;
	}
	
	public static void aumentaPontoJogador(Jogador jogador, int qtdPontos) {
		jogador.setPontos(jogador.getPontos()+qtdPontos);
	}
	
	public static void aumentaPontosJogadores(ArrayList<Jogador> jogadores, int qtdPontos) {
		for (Jogador jogador: jogadores) {
			jogador.setPontos(jogador.getPontos()+qtdPontos);
		}
	}
}

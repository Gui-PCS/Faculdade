import java.util.ArrayList;

public class Aluno {
	private String id;
	private String nome;
	private ArrayList<Rendimentos> historico = new ArrayList<Rendimentos>();
	
	public Aluno(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public void addMateria(Rendimentos mat) {
		this.historico.add(mat);
	}
	
	public void fazRelatorio() {
		String res = "";
		res+="O aluno "+this.nome+" de ID "+this.id+" está matriculado nas matérias:\n\n";
		for(Rendimentos mat: this.historico) {
			String aprov = "";
			if (mat.getAprovacao()) {
				aprov = "Aprovado";
			} else {
				aprov = "Reprovado";
			}
			res+=mat.materia.getNome()+" e está "+aprov+"\n";
		}
		System.out.println(res);
	}
}

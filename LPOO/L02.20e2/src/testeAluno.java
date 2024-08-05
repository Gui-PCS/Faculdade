
public class testeAluno {
	public static void main(String[] args) {
		Aluno al = new Aluno("id", "Nome");
		Materia ma = new Materia("Matematica", 2020);
		Notas not = new Notas();
		Rendimentos mat = new Rendimentos(ma, not);
		al.addMateria(mat);
		Materia ma1 = new Materia("Portugues", 2020);
		Notas not1 = new Notas();
		not.np1=3;
		not.exame=10;
		Rendimentos mat1 = new Rendimentos(ma1, not1);
		al.addMateria(mat1);
		al.fazRelatorio();
	}
}

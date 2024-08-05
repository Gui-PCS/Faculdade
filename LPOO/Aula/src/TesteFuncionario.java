
public class TesteFuncionario {
	public static void main(String[] args) {
		Funcionario f = new Funcionario("Rodolfo", "hgsgsj", 1500.00);
		
		System.out.println(f);
		
		f.aumentaSalarioPorcentagem(10);
		
		System.out.println(f);
	}
}


public class TesteFinanceiro {
	public static void main(String[] args) {
		Funcionario f = new Gerente("Roger", "a6e0", 1500.00);
		Financeiro.fazPagamento(f);
	}
}

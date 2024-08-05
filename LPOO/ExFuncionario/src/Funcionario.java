
public class Funcionario {
	private String id;
	private String nome;
	private double salario;
	
	public Funcionario(String aNome, String aId, double aSalario) {
		this.nome = aNome;
		this.id = aId;
		this.salario = aSalario;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getSalario() {
		return this.salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void aumentaSalarioPorcentagem(double umPorcento) {
		double porc = this.salario/100;
		
		this.salario = this.salario+(porc*umPorcento);
	}
	
	public void aumentaSalarioExato(double umValor) {
		this.salario = this.salario+umValor;
	}
	
	@Override
	public String toString() {
		return "O funcionário "+this.nome+" de id "+this.id+" recebe R$"+this.salario;
	}
}

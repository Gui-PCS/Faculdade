
public class Animal {
	private String nome;
	private int idade;
	private double peso;
	private boolean isDoente;
	
	public Animal(String nome, int idade, double peso) {
		this.nome = nome;
		this.idade = idade;
		this.isDoente = false;
	}
	
	public void aumentaIdade() {
		this.idade += 1;
	}
	
	public void darInjecao() {
		this.isDoente = false;
	}
	
	public void adoece() {
		this.isDoente = true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isDoente() {
		return isDoente;
	}

	public void setDoente(boolean isDoente) {
		this.isDoente = isDoente;
	}
	
	
}

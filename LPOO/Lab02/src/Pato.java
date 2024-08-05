
public class Pato {
	private String nome;
	private double idade;
	private double peso;
	private boolean doente;
	
	public Pato(String nome, double idade, double peso) {
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.doente = false;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getIdade() {
		return this.idade;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public boolean isDoente() {
		return this.doente;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void aumentaIdade() {
		this.idade++;
	}
	
	public void quack() {
		System.out.println("quaaack quaack");
	}
	
	public void dormir() {
		System.out.println("foi dormir no quintal");
	}
	
	public void comer() {
		System.out.println("comendo o que o pato come");
	}
	
	public void darInjecao() {
		this.doente = false;
	}
	
	public void adoece() {
		this.doente = true;
	}
}

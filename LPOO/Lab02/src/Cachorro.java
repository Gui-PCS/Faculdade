
public class Cachorro {
	private String nome;
	private double idade;
	private double peso;
	private boolean doente;
	
	public Cachorro(String nome, double idade, double peso) {
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
	
	public void latir() {
		if (this.idade < 4) {
			System.out.println("au au au");
		} else { if (this.idade <= 10) {
			System.out.println("AU AU AU");
		} else {
			System.out.println("ROOF ROOF ROOF");
		}}
	}
	
	public void dormir() {
		System.out.println("foi dormir no sofá");
	}
	
	public void comer() {
		System.out.println("comendo ração de cachorro");
	}
	
	public void darInjecao() {
		this.doente = false;
	}
	
	public void adoece() {
		this.doente = true;
	}
	
	
}

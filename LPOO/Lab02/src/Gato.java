
public class Gato {
	private String nome;
	private double idade;
	private double peso;
	private boolean doente;
	
	public Gato(String nome, double idade, double peso) {
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
	
	public void miar() {
		System.out.println("miaaauu ");
	}
	
	public void dormir() {
		System.out.println("foi dormir no alto");
	}
	
	public void comer() {
		System.out.println("comendo ração de gato");
	}
	
	public void darInjecao() {
		this.doente = false;
	}
	
	public void adoece() {
		this.doente = true;
	}
}


public class Gato {
	private String nome;
	private int idade;
	private double peso;
	
	public String getNome() {
		return this.nome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void setPeso(double umPeso) {
		this.peso = umPeso;
	}
	
	public void aumentaIdade() {
		this.idade++;
	}
	
	@Override
	public String toString(){
		String res = "";
		res += "Objeto Gato\n";
		res += "Nome: " + this.nome + "\n";
		res += "Idade: " + this.idade + "\n";
		res += "Peso: " + this.peso + "\n";
		return res;
	}
	
	public Gato(String aNome, double aPeso) {
		this.nome = aNome;
		this.idade = 0;
		this.peso = aPeso;
	}
	
	public Gato(String aNome, int aIdade, double aPeso) {
		this.nome = aNome;
		this.idade = aIdade;
		this.peso = aPeso;
	}
	
	void miar() {
		if (this.idade < 3) {
			System.out.println("miau miau miau, meu nome é "+this.nome+", eu tenho "+this.peso+" quilos");
		} else { if (this.idade <= 5) {
			System.out.println("miaaau, meu nome é "+this.nome+", eu tenho "+this.peso+" quilos");
		} else {
			System.out.println("Grrr, meu nome é "+this.nome+", eu tenho "+this.peso+" quilos");
		}}
	}
}


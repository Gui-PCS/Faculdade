
public class Gato extends Animal{

	public Gato(String nome, int idade, double peso) {
		super(nome, idade, peso);
	}
	
	public void latir() {
		System.out.println("miaaauu");
	}
	
	public void dormir() {
		System.out.println("foi dormir no alto");
	}
	
	public void comer() {
		System.out.println("comendo ração de gato");
	}
}

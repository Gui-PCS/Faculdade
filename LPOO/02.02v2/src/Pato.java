
public class Pato extends Animal{

	public Pato(String nome, int idade, double peso) {
		super(nome, idade, peso);
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
}

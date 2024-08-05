
public class Cachorro extends Animal{

	public Cachorro(String nome, int idade, double peso) {
		super(nome, idade, peso);
	}
	
	public void latir() {
		if (super.getIdade() < 3) {
			System.out.println("au au au");
		} else { if (super.getIdade() <= 10) {
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

}

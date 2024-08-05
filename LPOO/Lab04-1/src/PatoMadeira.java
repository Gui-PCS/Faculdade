
public class PatoMadeira extends Pato {
	
	public PatoMadeira(String n, int a) {
		super(n, a);
	}
	
	@Override
	public void voa() {
		System.out.println("O Pato n�o voa");
	}
	
	@Override
	public void nada() {
		System.out.println("O Pato boia");
	}
	
	@Override
	public void quack() {
		System.out.println("...");
	}

}


public class PatoMadeira extends Pato {
	
	public PatoMadeira(String n, int a) {
		super(n, a);
	}
	
	@Override
	public void voa() {
		System.out.println("O Pato não voa");
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

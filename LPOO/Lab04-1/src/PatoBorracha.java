
public class PatoBorracha extends Pato {
	String cor;
	public PatoBorracha(String n, int a, String c) {
		super(n, a);
		this.cor = c;
	}
	
	@Override
	public void voa() {
		System.out.println("O Pato "+this.cor+" não voa");
	}
	
	@Override
	public void nada() {
		System.out.println("O Pato "+this.cor+" boia");
	}
}


public class SuperPato extends Pato {
	float poder;
	public SuperPato(String n, int a, float p) {
		super(n, a);
		this.poder = p;
	}
	
	@Override
	public void voa() {
		System.out.println("Super Pato voa como um jato de poder "+this.poder);
	}
	
	@Override
	public void nada() {
		System.out.println("Super Pato nada como uma submarino de poder "+this.poder);
	}
	
	@Override
	public void quack() {
		System.out.println("QUACK");
	}
}

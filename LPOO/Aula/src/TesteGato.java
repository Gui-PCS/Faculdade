
public class TesteGato {
	public static void main(String[] args) {
		Gato g = new Gato("Moda", 5, 10.5);
		
		g.miar();
		
		System.out.println(g);
		
		g.aumentaIdade();

		g.miar();
		
		System.out.println(g);
	}
}

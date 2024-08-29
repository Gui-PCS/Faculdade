package testeProva;

public class PatoCasa implements PatoBehavior{

	@Override
	public void quack() {
		System.out.println("quack!");
		
	}

	@Override
	public void nada() {
		System.out.println("Nada na banheira!");
		
	}

}

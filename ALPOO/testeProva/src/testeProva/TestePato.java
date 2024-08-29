package testeProva;

public class TestePato {
	
	void testePato() {
		Pato pato = new Pato();
		pato.setBehavior(new PatoCasa());
		pato.quack();
		pato.nadar();
		pato.setBehavior(new PatoPraca());
		pato.quack();
		pato.nadar();
	}
	
	public class PatoPraca implements PatoBehavior{

		@Override
		public void quack() {
			System.out.println("QUACK!!!!!!");
			
		}

		@Override
		public void nada() {
			System.out.println("Nada no rio!");
			
		}

	}
	
	public static void main(String[] args) {
		new TestePato().testePato();
	}
}

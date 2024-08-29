
public class TestePato {
	public void testePato() {
		Pato pato = new Pato();
		pato.addCompVoar(new FazVoar());
		pato.addCompVoar(new FazNadar());
		pato.addCompVoar(new CompVoar() {

			@Override
			public void fazVoar() {
				System.out.println("Aff eu não quero voar");
			}});
		pato.addCompVoar(() -> System.out.println("Que sonim"));
		pato.voa();
	}
	
	class FazNadar implements CompVoar {

		@Override
		public void fazVoar() {
			System.out.println("O pato nada");
		}
		
	}
	
	public static void main(String[] args) {
		new TestePato.testePato();
	}
}

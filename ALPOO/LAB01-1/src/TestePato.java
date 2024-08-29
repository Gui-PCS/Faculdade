
public class TestePato {
	public static void testePato() {
		Pato pato = new Pato();
		CompVoar cv = new FazVoar();
		pato.setCompVoar(cv);
		pato.voa();
	}
	
	public static void main(String[] args) {
		testePato();
	}
}

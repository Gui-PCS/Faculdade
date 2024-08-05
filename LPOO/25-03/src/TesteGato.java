
public class TesteGato {
	public static void main(String[] args) {
		Gato gato = new GatoDaRua();
		GatoDaRua gato2 = new GatoDaRua();
		
		gato.comer();
		gato.dormir();
		gato2.comer();
		gato2.dormir();
	}
}

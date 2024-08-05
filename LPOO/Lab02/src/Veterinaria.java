public class Veterinaria {

	public static void cuidaDoCachorro(Cachorro cachorro) {
		System.out.println("Recebendo " + cachorro.getNome());
		if(!cachorro.isDoente()) {
			System.out.println("O cachorro está saudável");
			return;
		}

		System.out.println("Dando injeção para o animalzinho");
		cachorro.darInjecao();
		cachorro.latir();
		cachorro.comer();
		cachorro.dormir();
	}
	
	public static void cuidaDoGato(Gato gato) {
		System.out.println("Recebendo " + gato.getNome());
		if(!gato.isDoente()) {
			System.out.println("O gato está saudável");
			return;
		}

		System.out.println("Dando injeção para o animalzinho");
		gato.darInjecao();
		gato.miar();
		gato.comer();
		gato.dormir();
	}
	
	public static void cuidaDoPato(Pato pato) {
		System.out.println("Recebendo " + pato.getNome());
		if(!pato.isDoente()) {
			System.out.println("O pato está saudável");
			return;
		}

		System.out.println("Dando injeção para o animalzinho");
		pato.darInjecao();
		pato.quack();
		pato.comer();
		pato.dormir();
	}

}
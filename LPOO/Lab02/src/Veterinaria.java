public class Veterinaria {

	public static void cuidaDoCachorro(Cachorro cachorro) {
		System.out.println("Recebendo " + cachorro.getNome());
		if(!cachorro.isDoente()) {
			System.out.println("O cachorro est� saud�vel");
			return;
		}

		System.out.println("Dando inje��o para o animalzinho");
		cachorro.darInjecao();
		cachorro.latir();
		cachorro.comer();
		cachorro.dormir();
	}
	
	public static void cuidaDoGato(Gato gato) {
		System.out.println("Recebendo " + gato.getNome());
		if(!gato.isDoente()) {
			System.out.println("O gato est� saud�vel");
			return;
		}

		System.out.println("Dando inje��o para o animalzinho");
		gato.darInjecao();
		gato.miar();
		gato.comer();
		gato.dormir();
	}
	
	public static void cuidaDoPato(Pato pato) {
		System.out.println("Recebendo " + pato.getNome());
		if(!pato.isDoente()) {
			System.out.println("O pato est� saud�vel");
			return;
		}

		System.out.println("Dando inje��o para o animalzinho");
		pato.darInjecao();
		pato.quack();
		pato.comer();
		pato.dormir();
	}

}
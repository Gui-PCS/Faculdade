public class TestaVeterinaria {

	public static void main(String[] args) {
		Gato cachorro01 = new Gato("Brutus", 12, 5.0);
		Veterinaria.cuidaDoGato(cachorro01);

		cachorro01.adoece();
		Veterinaria.cuidaDoGato(cachorro01);
	}

}
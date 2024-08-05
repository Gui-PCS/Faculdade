
public class TesteConta {
	public static void main(String[] args) {
		ContaTelefone t = new ContaCelular("52465454567");
		t.minutos.add(3);
		t.minutos.add(5);
		t.minutos.add(20);
		System.out.println(t);
	}
}

import java.util.ArrayList;

public class ContaTelefone {
	String numero;
	ArrayList<Integer> minutos = new ArrayList<Integer>();
	
	public ContaTelefone(String num) {
		this.numero = num;
	}
	
	public int getTotalMinutos() {
		int total = 0;
		for (int minuto: this.minutos) {
			total+=minuto;
		}
		return total;
	}
	
	public double getValor() {
		int total = getTotalMinutos();
		double valor;
		if (total <= 30) {
			valor = total*0.6;
		} else {
			valor = total*0.8;
		}
		
		return valor;
	}
	
	@Override
	public String toString() {
		String res = "o número "+this.numero+" falou no total "+getTotalMinutos()+" minutos\n";
		res += " Total: "+getValor();
		return res;
	}
}

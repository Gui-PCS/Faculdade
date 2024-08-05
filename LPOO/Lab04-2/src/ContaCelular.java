
public class ContaCelular extends ContaTelefone{
	
	public ContaCelular(String num) {
		super(num);
	}

	@Override
	public double getValor() {
		int total = getTotalMinutos();
		double valor;
		if (total <= 30) {
			valor = total*1.2;
		} else {
			valor = total*1.4;
		}
		
		return valor;
	}
}


public class Posto {
	public void abastecerCarro(Carro carro, double qtdGas) {
		double t = this.abastecerTanque(carro.tanque, qtdGas);
		carro.tanque = t;
		
	}
	
	public double abastecerTanque(double tanque, double qtdGas) {
		tanque = tanque+qtdGas;
		
		return tanque;
	}
}

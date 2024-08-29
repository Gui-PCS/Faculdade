
public class Calculadora {
	
	CompCalc compCalc;
	
	public void setCompCalc(CompCalc cc) {
		this.compCalc = cc;
	}
	
	public void calcular(double a, double b) {
		this.compCalc.fazConta(a, b);
	}
}


public class TesteCalc {
	public void testCalc() {
		Calculadora calc = new Calculadora();
		calc.setCompCalc(new Soma());
		
		calc.calcular(3, 4);
		
		calc.setCompCalc((double a, double b) -> System.out.println("aaa"));
		
		calc.calcular(3, 4);
	}
	
	class Soma implements CompCalc{

		@Override
		public void fazConta(double a, double b) {
			System.out.println(a+b);
		}
		
	}
	
	public static void main(String[] args) {
		new TesteCalc().testCalc();
	}
}

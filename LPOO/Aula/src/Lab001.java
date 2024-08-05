
public class Lab001 {
	public static void main(String[] args) {
	    System.out.println(calculaVolumeLata(1, 1));
	    System.out.println(calculaVolumeLata(2, 1));
	    System.out.println(calculaVolumeLata(1, 2));
	    System.out.println(calculaVolumeLata(1, 1/Math.PI));
	    System.out.println(calculaVolumeLata(2, 1/Math.PI));
	    System.out.println(calculaVolumeLata(10, 1));
	    System.out.println(calculaVolumeLata(1, 10));
	    System.out.println(calculaVolumeLata(10, 10));
	}
	
	public static double calculaEstoqueMedio(double estoqueMinimo, double estoqueMaximo) {
		double estoqueMedio = (estoqueMinimo + estoqueMaximo)/2;
		return estoqueMedio;
	}
	
	public static double conversaoDolar(double cotacaoDolar, double valorDolar){
        double valorReal = cotacaoDolar*valorDolar;
        return valorReal;
    }
	
	public static double conversorCelsiusToFahrenheit(double grauC) {
		double f = (9*grauC+180)/5;
		return f;
	}
	
	public static double conversorFahrenheitToCelsius(double grauF) {
		double grauC = (grauF-32)*5/9;
		return grauC;
	}
	
	public static double calculaVolumeLata(double raio, double altura) {
		double volume = Math.PI*Math.pow(raio, 2)*altura;
        return volume;
	}
}

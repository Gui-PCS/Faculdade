
public class Sla {
	public static double calculaEstoqueMedio(double estoqueMinimo, double estoqueMaximo) {
		double em = (estoqueMinimo+estoqueMaximo)/2;
		return em;
	}
	
	public static double conversaoDolar(double cotacaoDolar, double valorDolar) {
		return cotacaoDolar*valorDolar;
	}

	public static double conversorCelsiusToFahrenheit(double grauC){
        double grauF = (9*grauC+180)/5;
        return grauF;
    }

	public static double conversorFahrenheitToCelsius(double temperaturaFahrenheit) {
		return (temperaturaFahrenheit-32)*5/9;
	}

	public static double calculaVolumeLata(double raio, double altura) {
		double v = Math.PI*Math.pow(raio, 2)*altura;
		return v;
	}
	
	public static int modulo(int n) {
		int x;
		if (n >= 0) {
			x = n;
		} else {
			x = -n;
		}
		return x;
	}
	
	public static int fatorial(int n){
        int resultado = 1;
        for(int i=1; i<=n; i++){
            resultado = resultado*i;
        }
        return resultado;
    }
	
	 public static int binomial(int n, int k){
	    int nFat = fatorial(n);
	    int kFat = fatorial(k);
	    int resultado = nFat/(kFat*fatorial(n-k));
	    return resultado;
	 }
}
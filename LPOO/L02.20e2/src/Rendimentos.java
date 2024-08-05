
public class Rendimentos {
	Materia materia;
	Notas notas;
	
	public Rendimentos(Materia ma, Notas not) {
		this.materia = ma;
		this.notas = not;
	}

	public boolean getAprovacao() {
		double media = (this.notas.np1+this.notas.np2)/2;
		if (media >= 7) {
			return true;
		} else {if ((media+this.notas.exame)/2 >=5) {
			return false;
		} else {
			return true;
		}}
	}
}

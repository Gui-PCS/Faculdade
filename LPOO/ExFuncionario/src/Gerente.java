
public class Gerente extends Funcionario{
	private double bonus = 3000.00;
	
	public Gerente(String aNome, String aId, double aSalario) {
		super(aNome, aId, aSalario);
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double getBonus() {
		return this.bonus;
	}
	
	public double getSalario() {
		return super.getSalario()+this.bonus;
	}
}

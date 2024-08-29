import java.util.List;
import java.util.ArrayList;

public class Pato {

	List<CompVoar> compVoarList = new ArrayList<>();
	
	public void addCompVoar(CompVoar aCompVoar) {
		this.compVoarList.add(aCompVoar);
	}
	
	void voa() {
		for (CompVoar compVoar: compVoarList) {
			compVoar.fazVoar();
		}
	}
}

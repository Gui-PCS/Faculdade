package testeProva;

public class Pato {
	
	PatoBehavior pbh;
	
	void setBehavior(PatoBehavior abh) {
		this.pbh = abh;
	}
	
	void quack() {
		this.pbh.quack();
	}
	
	void nadar() {
		this.pbh.nada();
	}

}

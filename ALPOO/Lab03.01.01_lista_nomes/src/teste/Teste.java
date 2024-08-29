package teste;

import controller.Controller;
import model.implementation.not_persistent.ModelNotPersistent;
import view.implementation.jframe.Janela;
import view.implementation.terminal.ViewTerminal;

public class Teste {
	
	public static void main(String[] args) {
		// teste com model not persistent e view terminal
		// new Controller(new ModelNotPersistent(), new ViewTerminal()).init();
		
		// teste com model not persistent e view janela
		new Controller(new ModelNotPersistent(), new Janela()).init();
	}

}

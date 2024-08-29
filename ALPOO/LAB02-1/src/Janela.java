import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame{
	public void init() {
		setLayout(new FlowLayout());
		
		ActionListener cont  = new Contador("B");
		
		JButton botaoA = new JButton("Botão A");
		botaoA.addActionListener(cont);
		add(botaoA);
		
		JButton botaoB = new JButton("Botão B");
		botaoB.addActionListener(cont);
		add(botaoB);
		
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	class Contador implements ActionListener{
		
		private String nome;
		private int contagem = 0;
		
		public Contador(String aNome) {
			this.nome = aNome;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			contagem++;
			System.out.println("Você precionou o botão"++"Os botôes foram precionados "+contagem+" vezes");
		}
	}
}

package view.implementation.jframe;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import view.View;

@SuppressWarnings("serial")
public class Janela extends JFrame implements View {

	DefaultListModel<String> listModel = new DefaultListModel<>();
	JList<String> listaNomes = new JList<>(listModel);
	
	JTextField textField = new JTextField(40);
	
	JButton botaoBuscar  = new JButton("Buscar");
	JButton botaoInserir = new JButton("Inserir");
	
	@Override
	public void init() {
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		add(textField);
		add(botaoBuscar);
		add(botaoInserir);
		
		JScrollPane listPanel = new JScrollPane(listaNomes);
		listPanel.setPreferredSize(new Dimension(400, 400));
		add(listPanel);
		
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void close() {
	}

	@Override
	public void addAcaoInserirNome(ActionListener al) {
		this.botaoInserir.addActionListener(al);
	}

	@Override
	public void addAcaoBuscarNome(ActionListener al) {
		this.botaoBuscar.addActionListener(al);
	}

	@Override
	public void mostrarNomes(List<String> nomes) {
		this.listModel.clear();
		int i=0;
		for(String nome: nomes)
			this.listModel.add(i++, nome);
	}

	@Override
	public String getNomeBusca() {
		return textField.getText();
	}

	@Override
	public String getNomeInserir() {
		return textField.getText();
	}
	
	

}

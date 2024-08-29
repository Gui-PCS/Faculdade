package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Model;
import view.View;

public class Controller {
	Model model;
	View view;
	
	public Controller(Model aModel, View aView){
		this.model = aModel;
		this.view = aView;
	}
	
	public void init(){
		view.addAcaoInserirNome(new AcaoInserirNome());
	    view.addAcaoBuscarNome(new AcaoBuscarNome());
	    
	    model.init();
	    view.init();
	    
	}
	
	class AcaoBuscarNome implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			
			String nome = view.getNomeBusca();
			
			List<String> nomes = model.buscarNome(nome);
			
			view.mostrarNomes(nomes);
	    }
	}
	
	class AcaoInserirNome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			
			String nome = view.getNomeInserir();
			
			model.inserirNome(nome);
		}
	}
}

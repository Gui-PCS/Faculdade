package view.implementation.terminal;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import view.View;

public class ViewTerminal implements View {
	
	ActionListener acaoInserirNome;
	ActionListener acaoBuscarNome;
	
	@SuppressWarnings("resource")
	@Override
	public void init() {
		boolean sair = false;
		
		while(!sair) {
			System.out.println("Escolha a opção");
			System.out.println("1 para inserir nome");
			System.out.println("2 para buscar nome");
			System.out.println("0 para sair");
			
			String opcao = new Scanner(System.in).nextLine();
			
			     if(opcao.trim().equals("1")) { this.acaoInserirNome.actionPerformed(null); }
			else if(opcao.trim().equals("2")) { this.acaoBuscarNome .actionPerformed(null); }
			else if(opcao.trim().equals("0")) { sair=true; }
			else {System.out.println("Opcao invalida");}
			
		}
	}

	@Override
	public void addAcaoInserirNome(ActionListener al) {
		this.acaoInserirNome = al;
	}

	@Override
	public void addAcaoBuscarNome(ActionListener al) {
		this.acaoBuscarNome = al;
	}

	@Override
	public void mostrarNomes(List<String> nomes) {
		System.out.println("Nomes: ");
		for(String nome: nomes)
			System.out.println(nome);
	}

	@SuppressWarnings("resource")
	@Override
	public String getNomeBusca() {
		System.out.println("Entre com o nome para buscar");
		return new Scanner(System.in).nextLine();
	}

	@SuppressWarnings("resource")
	@Override
	public String getNomeInserir() {
		System.out.println("Entre com o nome para inserir");
		return new Scanner(System.in).nextLine();
	}
	
	@Override
	public void close() {
		
	}

}

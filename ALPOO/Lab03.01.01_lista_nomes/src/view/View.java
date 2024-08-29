package view;

import java.awt.event.ActionListener;
import java.util.List;

public interface View {
	
	public void init();
	public void close();
	
	public void addAcaoInserirNome(ActionListener acaoInserirNome);
	public void addAcaoBuscarNome(ActionListener acaoBuscarNome);
	
	public void mostrarNomes(List<String> nomes);
	
	public String getNomeBusca();
	public String getNomeInserir();
}

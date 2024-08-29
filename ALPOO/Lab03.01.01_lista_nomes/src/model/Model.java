package model;

import java.util.List;

public interface Model {
	
	public void init();
	public void close();
	
	public List<String> buscarNome(String nome);
	public void inserirNome(String nome);
}

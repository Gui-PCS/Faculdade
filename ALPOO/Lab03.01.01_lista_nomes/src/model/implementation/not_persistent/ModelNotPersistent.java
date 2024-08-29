package model.implementation.not_persistent;

import java.util.ArrayList;
import java.util.List;

import model.Model;

public class ModelNotPersistent implements Model {
	
	List<String> nomes = new ArrayList<>();

	@Override
	public List<String> buscarNome(String nomeKey) {
		List<String> resultado = new ArrayList<>();
		for(String nome: this.nomes) {
			if(nome.toLowerCase().contains(nomeKey))
				resultado.add(nome);
		}
		return resultado;
	}

	@Override
	public void inserirNome(String nome) {
		this.nomes.add(nome);
	}
	
	@Override
	public void init() {}
	
	@Override
	public void close() {}

}

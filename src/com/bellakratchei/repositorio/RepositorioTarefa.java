package com.bellakratchei.repositorio;

import java.util.ArrayList;
import java.util.List;
import com.bellakratchei.models.Tarefa;

public class RepositorioTarefa implements RepositorioInterface<Integer, Tarefa>{
	
	private List<Tarefa> dbTarefas = new ArrayList<Tarefa>();

	public List<Tarefa> all() {
		return this.dbTarefas;
	}

	public Tarefa one(Integer id) {
		for(Tarefa t : this.dbTarefas) {
			if(t.getId().equals(id)) {
				return t;
			}
		}
		
		return null;
	}

	public void insert(Tarefa entidade) {
		this.dbTarefas.add(entidade);
	}

	public void update(Tarefa entidade) {
		for(Tarefa t : this.dbTarefas) {
			if(t.getId().equals(entidade.getId())) {
				t.setStatus(entidade.getStatus());
				t.setId_usuario(entidade.getId_usuario());
				t.setTitulo(entidade.getTitulo());
				t.setDescricao(entidade.getDescricao());
			}
		}
	}

	public void delete(Integer id) {
		int chave = 0;
		
		for(Tarefa t : this.dbTarefas) {
			if(t.getId().equals(id)) {
				this.dbTarefas.remove(chave);
			}
			chave++;
		}
	}
}

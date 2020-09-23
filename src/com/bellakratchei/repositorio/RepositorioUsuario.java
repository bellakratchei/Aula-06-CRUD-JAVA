package com.bellakratchei.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.bellakratchei.models.Usuario;

public class RepositorioUsuario implements RepositorioInterface<Integer, Usuario> {

	private List<Usuario> dbUsuarios = new ArrayList<Usuario>();
	
	public List<Usuario> all() {
		return this.dbUsuarios;
	}

	
	public Usuario one(Integer id) {
		for(Usuario u : this.dbUsuarios) {
			if(u.getId().equals(id)) {
				return u;
			}
		}
		
		return null;
	}

	public void insert(Usuario entidade) {
		this.dbUsuarios.add(entidade);
	}

	public void update(Usuario entidade) {
		for(Usuario u : this.dbUsuarios) {
			if(u.getId().equals(entidade.getId())) {
				u.setNome(entidade.getNome());
				u.setEmail(entidade.getEmail());
				u.setCargo(entidade.getCargo());
			}
		}
	}

	public void delete(Integer id) {
		int chave = 0;
		
		for(Usuario u : this.dbUsuarios) {
			if(u.getId().equals(id)) {
				this.dbUsuarios.remove(chave);
			}
			chave++;
		}
	}

}

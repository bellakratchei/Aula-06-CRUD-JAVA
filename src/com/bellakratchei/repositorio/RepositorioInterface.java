package com.bellakratchei.repositorio;

import java.util.List;

public interface RepositorioInterface <K,T> {
	
	public List<T> all();
	public T one(K id);
	public void insert(T entidade);
	public void update(T entidade);
	public void delete(K id);
}

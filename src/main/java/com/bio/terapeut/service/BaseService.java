package com.bio.terapeut.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {
	
	boolean NOT_ACTIVE = false;
	
	abstract void save(T dao);
	
	abstract void delete(Long id);
	
	abstract List<T> getAll();
	
	abstract T getOneById(Long id);
	
}

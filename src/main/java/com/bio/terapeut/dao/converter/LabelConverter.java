package com.bio.terapeut.dao.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bio.terapeut.dao.LabelDao;
import com.bio.terapeut.model.Label;

@Component
public class LabelConverter {
	
	public Label daoToEntity(LabelDao dao) {
		Label entity = new Label();
		entity.setId(dao.getId());
		entity.setValue(dao.getValue());
		return entity;
	}
	
	public LabelDao entityToDao(Label entity) {
		LabelDao dao = new LabelDao();
		dao.setId(entity.getId());
		dao.setValue(entity.getValue());
		return dao;
	}
	
	public List<Label> daoListToEntityList(List<LabelDao> daos) {
		List<Label> entities = new ArrayList<>();
		for(LabelDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}
	
	public List<LabelDao> entityListToDaoList(List<Label> entities) {
		List<LabelDao> daos = new ArrayList<>();
		for(Label entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}

}

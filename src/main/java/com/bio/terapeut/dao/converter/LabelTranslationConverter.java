package com.bio.terapeut.dao.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bio.terapeut.dao.LabelTranslationDao;
import com.bio.terapeut.model.LabelTranslation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
public class LabelTranslationConverter {
	private final LabelConverter converter;
	
	public LabelTranslation daoToEntity(LabelTranslationDao dao) {
		LabelTranslation entity = new LabelTranslation();
		entity.setId(dao.getId());
		entity.setRefLabelId(converter.daoToEntity(dao.getLabelId()));
		entity.setLanguage(dao.getLanguage());
		entity.setTranslationValue(dao.getTranslationValue());
		return entity;
	}
	
	public LabelTranslationDao entityToDao(LabelTranslation entity) {
		LabelTranslationDao dao = new LabelTranslationDao();
		dao.setId(entity.getId());
		dao.setLabelId(converter.entityToDao(entity.getRefLabelId()));
		dao.setLanguage(entity.getLanguage());
		dao.setTranslationValue(entity.getTranslationValue());
		return dao;
	}
	
	public List<LabelTranslation> daoListToEntityList(List<LabelTranslationDao> daos) {
		List<LabelTranslation> entities = new ArrayList<LabelTranslation>();
		for(LabelTranslationDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}
	
	public List<LabelTranslationDao> entityListToDaoList(List<LabelTranslation> entities) {
		List<LabelTranslationDao> daos = new ArrayList<>();
		for(LabelTranslation entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}

}

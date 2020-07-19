package com.bio.terapeut.dao.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bio.terapeut.dao.MerchendiseDao;
import com.bio.terapeut.model.Merchendise;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
public class MerchendiseConverter {
	
	private final LabelConverter converter; 
	
	public Merchendise daoToEntity(MerchendiseDao dao) {
		Merchendise entity = new Merchendise();
		entity.setId(dao.getId());
		entity.setDescription(dao.getDescription());
		entity.setName(dao.getName());
		entity.setPrice(dao.getPrice());
		entity.setType(dao.getType());
		entity.setRefLabelId(converter.daoToEntity(dao.getLabelId()));
		entity.setHasStock(dao.isHasStock());
		return entity;
	}
	
	public MerchendiseDao entityToDao(Merchendise entity) {
		MerchendiseDao dao = new MerchendiseDao();
		dao.setId(entity.getId());
		dao.setDescription(entity.getDescription());
		dao.setName(entity.getName());
		dao.setPrice(entity.getPrice());
		dao.setType(entity.getType());
		dao.setLabelId(converter.entityToDao(entity.getRefLabelId()));
		dao.setHasStock(entity.isHasStock());
		return dao;
	}
	
	public List<Merchendise> daoListToEntityList(List<MerchendiseDao> daos) {
		List<Merchendise> entities = new ArrayList<>();
		for(MerchendiseDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}
	
	public List<MerchendiseDao> entityListToDaoList(List<Merchendise> entities) {
		List<MerchendiseDao> daos = new ArrayList<>();
		for(Merchendise entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}

}

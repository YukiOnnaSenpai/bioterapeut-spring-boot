package com.bio.terapeut.dao.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bio.terapeut.dao.LocationDao;
import com.bio.terapeut.model.Location;

@Component
public class LocationConverter {
	
	public Location daoToEntity(LocationDao dao) {
		Location entity = new Location();
		entity.setAddress(dao.getAddress());
		entity.setCity(dao.getCity());
		entity.setCountry(dao.getCountry());
		entity.setId(dao.getId());
		entity.setLanguage(dao.getLanguage());
		return entity;
	}
	
	public LocationDao entityToDao(Location entity) {
		LocationDao dao = new LocationDao();
		dao.setAddress(entity.getAddress());
		dao.setCity(entity.getCity());
		dao.setCountry(entity.getCountry());
		dao.setId(entity.getId());
		dao.setLanguage(entity.getLanguage());
		return dao;
	}
	
	public List<Location> daoListToEntityList(List<LocationDao> daos) {
		List<Location> entities = new ArrayList<>();
		for(LocationDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}
	
	public List<LocationDao> entityListToDaoList(List<Location> entities) {
		List<LocationDao> daos = new ArrayList<>();
		for(Location entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}

}

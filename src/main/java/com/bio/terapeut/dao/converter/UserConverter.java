package com.bio.terapeut.dao.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bio.terapeut.dao.LocationDao;
import com.bio.terapeut.dao.UserDao;
import com.bio.terapeut.model.ApplicationUser;
import com.bio.terapeut.model.Location;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserConverter {
	
	private final LocationConverter converter;
	
	public UserDao entityToDao(ApplicationUser entity) {
		UserDao dao = new UserDao();
		dao.setId(entity.getId());
		dao.setAccountType(entity.getAccountType());
		dao.setEmail(entity.getEmail());
		dao.setFirstName(entity.getFirstName());
		dao.setLastName(entity.getLastName());
		Location location = entity.getRefLocationId();
		if(location != null) {
			dao.setLocationId(converter.entityToDao(entity.getRefLocationId()));
		}
		dao.setPhone(entity.getPhone());
		return dao;
	}
	
	public ApplicationUser daoToEntity(UserDao dao) {
		ApplicationUser entity = new ApplicationUser();
		entity.setId(dao.getId());
		entity.setAccountType(dao.getAccountType());
		entity.setEmail(dao.getEmail());
		entity.setFirstName(dao.getFirstName());
		entity.setLastName(dao.getLastName());
		LocationDao locationDao = dao.getLocationId();
		if(locationDao != null) {
			entity.setRefLocationId(converter.daoToEntity(dao.getLocationId()));
		}
		entity.setPhone(dao.getPhone());
		return entity;
	}
	
	public List<ApplicationUser> daoListToEntityList(List<UserDao> daos) {
		List<ApplicationUser> entities = new ArrayList<>();
		for(UserDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}
	
	public List<UserDao> entityListToDaoList(List<ApplicationUser> entities) {
		List<UserDao> daos = new ArrayList<>();
		for(ApplicationUser entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}

}

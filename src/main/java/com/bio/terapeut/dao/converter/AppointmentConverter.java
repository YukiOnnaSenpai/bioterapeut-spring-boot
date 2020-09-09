package com.bio.terapeut.dao.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bio.terapeut.dao.AppointmentDao;
import com.bio.terapeut.model.Appointment;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AppointmentConverter {
	
	private final LocationConverter locationConverter;
	private final LabelConverter labelConverter;
	
	public Appointment daoToEntity(AppointmentDao dao) {
		Appointment entity = new Appointment();
		entity.setId(dao.getId());
		entity.setDateTimeEnd(entity.getDateTimeEnd());
		entity.setDateTimeStart(entity.getDateTimeStart());
		entity.setDescription(dao.getDescription());
		entity.setPrice(dao.getPrice());
		entity.setType(dao.getType());
		entity.setRefLabelId(labelConverter.daoToEntity(dao.getRefLabelDaoId()));
		entity.setRefLocationId(locationConverter.daoToEntity(dao.getRefLocationDaoId()));
		return entity;
	}
	
	public AppointmentDao entityToDao(Appointment entity) {
		AppointmentDao dao = new AppointmentDao();
		dao.setId(entity.getId());
		dao.setDateTimeEnd(entity.getDateTimeEnd());
		dao.setDateTimeStart(entity.getDateTimeStart());
		dao.setDescription(entity.getDescription());
		dao.setRefLabelDaoId(labelConverter.entityToDao(entity.getRefLabelId()));
		dao.setRefLocationDaoId(locationConverter.entityToDao(entity.getRefLocationId()));
		dao.setPrice(entity.getPrice());
		dao.setType(entity.getType());
		return dao;
	}
	
	public List<Appointment> daoListToEntityList(List<AppointmentDao> daos) {
		List<Appointment> entities = new ArrayList<>();
		for(AppointmentDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}
	
	public List<AppointmentDao> entityListToDaoList(List<Appointment> entities) {
		List<AppointmentDao> daos = new ArrayList<>();
		for(Appointment entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}

}

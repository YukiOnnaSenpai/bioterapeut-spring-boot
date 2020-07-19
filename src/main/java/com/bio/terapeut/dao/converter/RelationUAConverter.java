package com.bio.terapeut.dao.converter;

import org.springframework.stereotype.Component;

import com.bio.terapeut.dao.RelationUADao;
import com.bio.terapeut.model.RelationUserAppointment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
public class RelationUAConverter {
	
	private final AppointmentConverter appointmentConverter;
	private final UserConverter userConverter;
	
	public RelationUserAppointment daoToEntity(RelationUADao dao) {
		RelationUserAppointment entity = new RelationUserAppointment();
		entity.setId(dao.getId());
		entity.setRefAppointmentId(appointmentConverter.daoToEntity(dao.getAppointmentId()));
		entity.setRefUserId(userConverter.daoToEntity(dao.getUserId()));
		entity.setAttendanceStatus(dao.getAttendanceStatus());
		entity.setComment(dao.getComment());
		entity.setRating(dao.getRating());
		return entity;
	}
	
	public RelationUADao entityToDao(RelationUserAppointment entity) {
		RelationUADao dao = new RelationUADao();
		dao.setId(entity.getId());
		dao.setAppointmentId(appointmentConverter.entityToDao(entity.getRefAppointmentId()));
		dao.setAttendanceStatus(entity.getAttendanceStatus());
		dao.setComment(entity.getComment());
		dao.setRating(entity.getRating());
		dao.setUserId(userConverter.entityToDao(entity.getRefUserId()));
		return dao;
	}

}

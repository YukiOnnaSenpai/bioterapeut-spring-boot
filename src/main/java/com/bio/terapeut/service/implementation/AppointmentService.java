package com.bio.terapeut.service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bio.terapeut.dao.AppointmentDao;
import com.bio.terapeut.dao.converter.AppointmentConverter;
import com.bio.terapeut.model.Appointment;
import com.bio.terapeut.repository.implementations.AppointmentRepository;
import com.bio.terapeut.service.BaseService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AppointmentService implements BaseService<AppointmentDao, Long>{
	
	private final AppointmentRepository repository;
	private final AppointmentConverter converter;

	@Override
	public void save(AppointmentDao dao) {
		Appointment entity = converter.daoToEntity(dao);
		repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		Appointment deletable = converter.daoToEntity(getOneById(id));
		deletable.setActive(NOT_ACTIVE);
		repository.save(deletable);
	}

	@Override
	public List<AppointmentDao> getAll() {
		return converter.entityListToDaoList(repository.findAll());
	}

	@Override
	public AppointmentDao getOneById(Long id) {
		return converter.entityToDao(repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT)));
	}
}

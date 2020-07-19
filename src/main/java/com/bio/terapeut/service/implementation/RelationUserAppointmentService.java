package com.bio.terapeut.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bio.terapeut.dao.RelationUADao;
import com.bio.terapeut.dao.converter.RelationUAConverter;
import com.bio.terapeut.dao.converter.UserConverter;
import com.bio.terapeut.model.RelationUserAppointment;
import com.bio.terapeut.repository.implementations.RelationUserAppointmentRepository;
import com.bio.terapeut.repository.implementations.UserRepository;
import com.bio.terapeut.service.BaseService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class RelationUserAppointmentService implements BaseService<RelationUADao, Long>{
	
	private final RelationUserAppointmentRepository repository;
	private final RelationUAConverter converter; 

	@Override
	public void save(RelationUADao dao) {
		repository.save(converter.daoToEntity(dao));
	}

	@Override
	public void delete(Long id) {
		RelationUserAppointment deletable = converter.daoToEntity(getOneById(id));
		deletable.setActive(NOT_ACTIVE);
		repository.save(deletable);
	}

	@Override
	public List<RelationUADao> getAll() {
		List<RelationUserAppointment> entities = repository.findAll();
		List<RelationUADao> daos = new ArrayList<>();
		for(RelationUserAppointment entity : entities) {
			daos.add(converter.entityToDao(entity));
		}
		return  daos;
	}

	@Override
	public RelationUADao getOneById(Long id) {
		return converter.entityToDao(repository.findById(id).get());
	}


}

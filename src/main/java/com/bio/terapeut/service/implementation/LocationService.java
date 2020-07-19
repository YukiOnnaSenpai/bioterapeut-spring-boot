package com.bio.terapeut.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bio.terapeut.dao.LocationDao;
import com.bio.terapeut.dao.converter.LocationConverter;
import com.bio.terapeut.dao.converter.UserConverter;
import com.bio.terapeut.model.Location;
import com.bio.terapeut.repository.implementations.LocationRepository;
import com.bio.terapeut.repository.implementations.UserRepository;
import com.bio.terapeut.service.BaseService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class LocationService implements BaseService<LocationDao, Long>{

	private final LocationRepository repository;
	private final LocationConverter converter;

	@Override
	public void save(LocationDao dao) {
		repository.save(converter.daoToEntity(dao));
	}

	@Override
	public void delete(Long id) {
		Location deletable = converter.daoToEntity(getOneById(id));
		deletable.setActive(NOT_ACTIVE);
		repository.save(deletable);
	}

	@Override
	public List<LocationDao> getAll() {
		return converter.entityListToDaoList(repository.findAll());
	}

	@Override
	public LocationDao getOneById(Long id) {
		return converter.entityToDao(repository.findById(id).get());
	}
	
}

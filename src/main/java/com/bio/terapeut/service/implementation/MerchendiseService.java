package com.bio.terapeut.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bio.terapeut.dao.MerchendiseDao;
import com.bio.terapeut.dao.converter.MerchendiseConverter;
import com.bio.terapeut.model.Merchendise;
import com.bio.terapeut.repository.implementations.MerchendiseRepository;
import com.bio.terapeut.service.BaseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MerchendiseService implements BaseService<MerchendiseDao, Long>{
	
	private final MerchendiseRepository repository;
	private final MerchendiseConverter converter;

	@Override
	public void save(MerchendiseDao dao) {
		repository.save(converter.daoToEntity(dao));
	}

	@Override
	public void delete(Long id) {
		Merchendise deletable = converter.daoToEntity(getOneById(id));
		deletable.setActive(NOT_ACTIVE);
		repository.save(deletable);
	}

	@Override
	public List<MerchendiseDao> getAll() {
		return converter.entityListToDaoList(repository.findAll());
	}

	@Override
	public MerchendiseDao getOneById(Long id) {
		return converter.entityToDao(repository.findById(id).get());
	}



}

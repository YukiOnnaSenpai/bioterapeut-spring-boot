package com.bio.terapeut.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bio.terapeut.dao.LabelDao;
import com.bio.terapeut.dao.converter.LabelConverter;
import com.bio.terapeut.model.Label;
import com.bio.terapeut.repository.implementations.LabelRepository;
import com.bio.terapeut.service.BaseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LabelService implements BaseService<LabelDao, Long>{
	
	private final LabelRepository repository;
	private final LabelConverter converter;

	@Override
	public void save(LabelDao dao) {
		Label entity = converter.daoToEntity(dao);
		repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		Label deletable = converter.daoToEntity(getOneById(id));
		deletable.setActive(NOT_ACTIVE);
		repository.save(deletable);
	}

	@Override
	public List<LabelDao> getAll() {
		return converter.entityListToDaoList(repository.findAll());
	}

	@Override
	public LabelDao getOneById(Long id) {
		return converter.entityToDao(repository.getOne(id));
	}

}

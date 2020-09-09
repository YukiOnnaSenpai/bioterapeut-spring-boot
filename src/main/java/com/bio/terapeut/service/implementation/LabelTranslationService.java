package com.bio.terapeut.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bio.terapeut.dao.LabelTranslationDao;
import com.bio.terapeut.dao.converter.LabelTranslationConverter;
import com.bio.terapeut.model.LabelTranslation;
import com.bio.terapeut.repository.implementations.LabelTranslationRepository;
import com.bio.terapeut.service.BaseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LabelTranslationService implements BaseService<LabelTranslationDao, Long>{
	
	private final LabelTranslationRepository repository;
	private final LabelTranslationConverter converter;

	@Override
	public void save(LabelTranslationDao dao) {
		repository.save(converter.daoToEntity(dao));
	}

	@Override
	public void delete(Long id) {
		LabelTranslation deletable = converter.daoToEntity(getOneById(id));
		deletable.setActive(NOT_ACTIVE);
		repository.save(deletable);
	}

	@Override
	public List<LabelTranslationDao> getAll() {
		return converter.entityListToDaoList(repository.findAll());
	}

	@Override
	public LabelTranslationDao getOneById(Long id) {
		return converter.entityToDao(repository.findById(id).get());
	}


}

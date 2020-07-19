package com.bio.terapeut.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bio.terapeut.dao.UserDao;
import com.bio.terapeut.dao.converter.UserConverter;
import com.bio.terapeut.model.ApplicationUser;
import com.bio.terapeut.repository.implementations.UserRepository;
import com.bio.terapeut.service.BaseService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements BaseService<UserDao, Long>{
	
	private final UserRepository repository;
	private final UserConverter converter;

	@Override
	public void save(UserDao dao) {
		repository.save(converter.daoToEntity(dao));
	}

	@Override
	public void delete(Long id) {
		ApplicationUser deletable = converter.daoToEntity(getOneById(id));
		deletable.setActive(NOT_ACTIVE);
		repository.save(deletable);
	}

	@Override
	public List<UserDao> getAll() {
		return converter.entityListToDaoList(repository.findAll());
	}

	@Override
	public UserDao getOneById(Long id) {
		return converter.entityToDao(repository.findById(id).get());
	}


}

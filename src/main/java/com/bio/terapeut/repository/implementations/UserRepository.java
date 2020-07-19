package com.bio.terapeut.repository.implementations;

import org.springframework.stereotype.Repository;

import com.bio.terapeut.model.ApplicationUser;
import com.bio.terapeut.repository.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<ApplicationUser, Long>{

}

package com.bio.terapeut.repository.implementations;

import org.springframework.stereotype.Repository;

import com.bio.terapeut.model.Appointment;
import com.bio.terapeut.repository.BaseRepository;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment, Long>{

}

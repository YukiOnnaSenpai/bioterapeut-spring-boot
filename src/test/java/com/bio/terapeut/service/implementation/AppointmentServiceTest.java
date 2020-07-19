package com.bio.terapeut.service.implementation;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bio.terapeut.dao.AppointmentDao;
import com.bio.terapeut.dao.converter.AppointmentConverter;
import com.bio.terapeut.model.Appointment;
import com.bio.terapeut.repository.implementations.AppointmentRepository;

@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceTest {

	@Mock
	private AppointmentRepository appointmentRepository;
	@Mock
	private AppointmentConverter appointmentConverter;
	@InjectMocks
	private AppointmentService appointmentService;
	
	@Test
	public void getAll_appointmentsExists_shouldReturnAppointment() {
		Appointment appointment = new Appointment();
		Mockito.when(appointmentRepository.findAll()).thenReturn(List.of(appointment));
		Mockito.when(appointmentConverter.entityListToDaoList(Mockito.any())).thenReturn(List.of(new AppointmentDao()));
		
		List<AppointmentDao> appointments = appointmentService.getAll();
		
		Assertions.assertThat(appointments.size()).isEqualTo(1);
	}
}

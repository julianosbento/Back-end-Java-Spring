package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	public Appointment findById(Long id);
}

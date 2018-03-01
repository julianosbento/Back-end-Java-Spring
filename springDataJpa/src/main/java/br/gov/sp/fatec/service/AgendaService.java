package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Appointment;
import br.gov.sp.fatec.model.User;

public interface AgendaService {
    public Iterable<Appointment> getAllAppointments(User user);
    public Appointment addAppointment(Appointment appointment);
    public Appointment updateAppointment(
            Long appointmentID, Appointment appointment);
    public void deleteAppointment(Long appointmentID);
}

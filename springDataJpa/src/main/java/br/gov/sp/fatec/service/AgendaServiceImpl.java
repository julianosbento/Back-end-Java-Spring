package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Appointment;
import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.AppointmentRepository;
import br.gov.sp.fatec.repository.UsuarioRepository;


@Service("agendaService")
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private UsuarioRepository userRepo;

    public Iterable<Appointment> getAllAppointments(User user) {
        Iterable<Appointment> appointments;
        appointments = appointmentRepo.findAll();
        return appointments;
    };

    public Appointment addAppointment(Appointment appointment) {
        Usuario user = userRepo.findById(3L);
        appointment.setUsuario(user);
        return appointmentRepo.save(appointment);
    }
    
    public Appointment updateAppointment(
            Long appointmentID, Appointment appointment) {
        Appointment oldAppointment = appointmentRepo.findById(appointmentID);
        if (oldAppointment != null) {
            oldAppointment.setDate(appointment.getDate());
            appointmentRepo.save(oldAppointment);
        }
        return oldAppointment;
    };

    public void deleteAppointment(Long appointmentID) {
        Appointment appt = appointmentRepo.findOne(appointmentID);
        appointmentRepo.delete(appt);
    }
}

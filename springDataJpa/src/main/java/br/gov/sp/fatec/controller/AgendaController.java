package br.gov.sp.fatec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Appointment;
import br.gov.sp.fatec.service.AgendaService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value="/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    public void setAgendaService(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @JsonView(View.All.class)
    @RequestMapping(value="/", method=RequestMethod.GET)
    @CrossOrigin
    public ResponseEntity<Iterable<Appointment>> get() {
        Iterable<Appointment> appointments;
        appointments = agendaService.getAllAppointments(null);
        return new ResponseEntity<Iterable<Appointment>>(
                appointments, HttpStatus.OK);
    }

    @JsonView(View.All.class)
    @RequestMapping(value="/", method=RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<Appointment> post(
            @RequestBody Appointment appointment,
            HttpServletRequest request, HttpServletResponse response) {
        agendaService.addAppointment(appointment);
        return new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);
    }

    @JsonView(View.All.class)
    @RequestMapping(value="/{appointmentID}", method=RequestMethod.PUT)
    @CrossOrigin
    public ResponseEntity<Appointment> update(
            @PathVariable("appointmentID") Long id,
            @RequestBody Appointment appointment) {
        Appointment updatedAppointment = agendaService
            .updateAppointment(id, appointment);

        if (updatedAppointment == null) {
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
    }

    @JsonView(View.All.class)
    @RequestMapping(value="/{appointmentID}", method=RequestMethod.DELETE)
    @CrossOrigin
    public ResponseEntity delete(
            @PathVariable("appointmentID") Long appointmentID) {
        agendaService.deleteAppointment(appointmentID);
        return new ResponseEntity(HttpStatus.OK);
    }
}

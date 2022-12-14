package com.sample.demo.service;

import com.sample.demo.model.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    Appointment updateAppointment(Appointment appointment);

    void deleteAppointment(Long appointmentId);

    Appointment updateAppointmentStatus(Appointment appointment);

    List<Appointment> findAll();
}

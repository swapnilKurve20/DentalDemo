package com.sample.demo.DentalDemo.service.impl;

import com.sample.demo.DentalDemo.dao.AppointmentRepository;
import com.sample.demo.DentalDemo.model.Appointment;
import com.sample.demo.DentalDemo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public Appointment updateAppointmentStatus(Appointment appointment) {
        List<Appointment> byUserId = appointmentRepository.findByUserId(appointment.getId());
        if(byUserId.size() > 0 && !ObjectUtils.isEmpty(appointment.getStatus())){
            Appointment userAppointment = byUserId.stream().filter(apt -> apt.getId() == appointment.getId()).findAny().get();
            userAppointment.setStatus(appointment.getStatus());
            appointmentRepository.save(userAppointment);
        }
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
}

package com.sample.demo.DentalDemo.controller;

import com.sample.demo.DentalDemo.model.Appointment;
import com.sample.demo.DentalDemo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<Appointment> findAllAppointments(){
        return appointmentService.findAll();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    Appointment bookAppointment(@RequestBody Appointment appointment){
        return appointmentService.createAppointment(appointment);
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    Appointment updateAppointment(@RequestBody Appointment appointment){
        return appointmentService.updateAppointment(appointment);
    }

    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.DELETE)
    void deleteAppointment(@PathVariable Long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
    }
}

package com.sample.demo.dao;

import com.sample.demo.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("select a from Appointment a where a.bookedByUserId = :userId")
    List<Appointment> findByUserId(@Param("userId") Long userId);

    @Query("select a from Appointment a where a.bookedForDrID = :drId")
    List<Appointment> findByDoctorId(@Param("drId") Long drId);
}

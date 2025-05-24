package com.cts.employee_attendance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;
    private LocalTime clockInTime;
    private LocalTime clockOutTime;
    private double workHours;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}

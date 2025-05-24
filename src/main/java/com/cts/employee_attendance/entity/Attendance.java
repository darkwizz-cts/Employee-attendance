package com.cts.employee_attendance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

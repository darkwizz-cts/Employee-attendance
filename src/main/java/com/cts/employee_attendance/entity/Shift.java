package com.cts.employee_attendance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ShiftID;
    private LocalDate ShiftDate;
    private LocalTime ShiftTime;

    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
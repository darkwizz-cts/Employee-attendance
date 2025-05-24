package com.cts.employee_attendance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Shift {

    @Id
    private int ShiftID;
    private LocalDate ShiftDate;
    private LocalDate ShiftTime;

    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
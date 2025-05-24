package com.cts.employee_attendance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
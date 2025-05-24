package com.cts.employee_attendance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reportID;
    int dateRange;
    int totalAttendance;
    int absenteeism;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}

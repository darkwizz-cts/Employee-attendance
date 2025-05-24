package com.cts.employee_attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class AttendanceReport {
    @Id
    int reportID;
    int dateRange;
    int totalAttendance;
    int absenteeism;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}

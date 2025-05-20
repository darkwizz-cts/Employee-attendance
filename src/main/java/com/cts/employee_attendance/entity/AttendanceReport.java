package com.cts.employee_attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AttendanceReport {
    @Id
    int ReportID;
    int EmployeeID;
    String DateRange;
    int TotalAttendance;
    int Absenteeism;
}

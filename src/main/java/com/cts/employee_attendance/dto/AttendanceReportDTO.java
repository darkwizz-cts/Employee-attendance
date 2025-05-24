package com.cts.employee_attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceReportDTO {
    private int reportID;
    private int dateRange;
    private int totalAttendance;
    private int absenteeism;
    private int employeeId;
}
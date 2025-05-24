package com.cts.employee_attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {
    private int attendanceId;
    private LocalTime clockInTime;
    private LocalTime clockOutTime;
    private double workHours;
    private int employeeId;
}
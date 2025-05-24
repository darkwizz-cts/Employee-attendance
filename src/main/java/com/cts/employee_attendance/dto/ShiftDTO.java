package com.cts.employee_attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftDTO {
    private int ShiftID;
    private LocalDate ShiftDate;
    private LocalTime ShiftTime;
    private int employeeId;
}

package com.cts.employee_attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftDTO {
    private int ShiftID;
    private LocalDate ShiftDate;
    private LocalDate ShiftTime;
    private int employeeId;
}

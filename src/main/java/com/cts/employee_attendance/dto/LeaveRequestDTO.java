package com.cts.employee_attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequestDTO {
    private int leaveId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private int employeeId;
}
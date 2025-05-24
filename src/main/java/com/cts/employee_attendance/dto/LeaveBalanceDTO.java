package com.cts.employee_attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveBalanceDTO {
    private int leaveBalanceId;
    private String leaveType;
    private int balance;
    private int employeeId;
}
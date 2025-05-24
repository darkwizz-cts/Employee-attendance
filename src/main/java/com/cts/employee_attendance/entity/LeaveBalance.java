package com.cts.employee_attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class LeaveBalance {
    @Id
    private int leaveBalanceId;
    private String leaveType;
    private int balance;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}

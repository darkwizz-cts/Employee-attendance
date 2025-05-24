package com.cts.employee_attendance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LeaveBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaveBalanceId;
    private String leaveType;
    private int balance;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}

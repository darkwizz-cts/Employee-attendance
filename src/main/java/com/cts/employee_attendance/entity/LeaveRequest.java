package com.cts.employee_attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

enum LeaveType{
    
}
@Data
@Entity
public class LeaveRequest {
    @Id
    int leaveId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}

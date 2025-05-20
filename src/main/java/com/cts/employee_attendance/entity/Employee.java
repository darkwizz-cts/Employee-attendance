package com.cts.employee_attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    int employeeId;
    int shiftId;
    int leaveBalance;
    String employeeName;
}

package com.cts.employee_attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Shift {

    @Id
    int ShiftID;
    int EmployeeID;
    String ShiftDate;
    String ShiftTime;
}
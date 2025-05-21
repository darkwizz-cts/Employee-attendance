package com.cts.employee_attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Shift {

    @Id
    int ShiftID;
    int EmployeeID;
    Date ShiftDate;
    Date ShiftTime;
}
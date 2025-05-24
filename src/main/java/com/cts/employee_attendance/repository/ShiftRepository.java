package com.cts.employee_attendance.repository;

import com.cts.employee_attendance.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {
    List<Shift> findByEmployeeEmployeeId(int employeeId);
}
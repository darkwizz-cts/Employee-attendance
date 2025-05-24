package com.cts.employee_attendance.repository;

import com.cts.employee_attendance.entity.AttendanceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AttendanceReportRepository extends JpaRepository<AttendanceReport, Integer> {
    List<AttendanceReport> findByEmployeeEmployeeId(int employeeId);
}
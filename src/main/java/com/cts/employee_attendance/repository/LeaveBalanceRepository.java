package com.cts.employee_attendance.repository;

import com.cts.employee_attendance.entity.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer> {
    List<LeaveBalance> findByEmployeeEmployeeId(int employeeId);
}
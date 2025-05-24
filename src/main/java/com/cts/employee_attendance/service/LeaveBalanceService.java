package com.cts.employee_attendance.service;

import com.cts.employee_attendance.dto.LeaveBalanceDTO;
import java.util.List;

public interface LeaveBalanceService {
    List<LeaveBalanceDTO> getAllLeaveBalances();
    LeaveBalanceDTO getLeaveBalanceById(int id);
    List<LeaveBalanceDTO> getLeaveBalancesByEmployeeId(int employeeId);
    LeaveBalanceDTO createLeaveBalance(LeaveBalanceDTO leaveBalanceDTO);
    LeaveBalanceDTO updateLeaveBalance(int id, LeaveBalanceDTO leaveBalanceDTO);
    void deleteLeaveBalance(int id);
}
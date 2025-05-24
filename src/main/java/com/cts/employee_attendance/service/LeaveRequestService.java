package com.cts.employee_attendance.service;

import com.cts.employee_attendance.dto.LeaveRequestDTO;
import java.util.List;

public interface LeaveRequestService {
    List<LeaveRequestDTO> getAllLeaveRequests();
    LeaveRequestDTO getLeaveRequestById(int id);
    List<LeaveRequestDTO> getLeaveRequestsByEmployeeId(int employeeId);
    LeaveRequestDTO createLeaveRequest(LeaveRequestDTO leaveRequestDTO);
    LeaveRequestDTO updateLeaveRequest(int id, LeaveRequestDTO leaveRequestDTO);
    void deleteLeaveRequest(int id);
}
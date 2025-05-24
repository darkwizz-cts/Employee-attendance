package com.cts.employee_attendance.service;

import com.cts.employee_attendance.dto.AttendanceDTO;
import java.util.List;

public interface AttendanceService {
    List<AttendanceDTO> getAllAttendances();
    AttendanceDTO getAttendanceById(int id);
    List<AttendanceDTO> getAttendancesByEmployeeId(int employeeId);
    AttendanceDTO createAttendance(AttendanceDTO attendanceDTO);
    AttendanceDTO updateAttendance(int id, AttendanceDTO attendanceDTO);
    void deleteAttendance(int id);
}
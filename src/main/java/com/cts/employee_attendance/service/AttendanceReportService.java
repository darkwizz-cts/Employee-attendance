package com.cts.employee_attendance.service;

import com.cts.employee_attendance.dto.AttendanceReportDTO;
import java.util.List;

public interface AttendanceReportService {
    List<AttendanceReportDTO> getAllAttendanceReports();
    AttendanceReportDTO getAttendanceReportById(int id);
    List<AttendanceReportDTO> getAttendanceReportsByEmployeeId(int employeeId);
    AttendanceReportDTO createAttendanceReport(AttendanceReportDTO attendanceReportDTO);
    AttendanceReportDTO updateAttendanceReport(int id, AttendanceReportDTO attendanceReportDTO);
    void deleteAttendanceReport(int id);
}
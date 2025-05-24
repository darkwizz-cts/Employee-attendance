package com.cts.employee_attendance.service;

import com.cts.employee_attendance.dto.ShiftDTO;
import java.util.List;

public interface ShiftService {
    List<ShiftDTO> getAllShifts();
    ShiftDTO getShiftById(int id);
    ShiftDTO getShiftByEmployeeId(int employeeId);
    ShiftDTO createShift(ShiftDTO shiftDTO);
    ShiftDTO updateShift(int id, ShiftDTO shiftDTO);
    void deleteShift(int id);
}
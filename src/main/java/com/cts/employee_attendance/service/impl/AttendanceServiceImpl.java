package com.cts.employee_attendance.service.impl;

import com.cts.employee_attendance.dto.AttendanceDTO;
import com.cts.employee_attendance.entity.Attendance;
import com.cts.employee_attendance.entity.Employee;
import com.cts.employee_attendance.exception.ResourceNotFoundException;
import com.cts.employee_attendance.repository.AttendanceRepository;
import com.cts.employee_attendance.repository.EmployeeRepository;
import com.cts.employee_attendance.service.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, 
                               EmployeeRepository employeeRepository,
                               ModelMapper modelMapper) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AttendanceDTO> getAllAttendances() {
        List<Attendance> attendances = attendanceRepository.findAll();
        return attendances.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceDTO getAttendanceById(int id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: " + id));
        return convertToDTO(attendance);
    }

    @Override
    public List<AttendanceDTO> getAttendancesByEmployeeId(int employeeId) {
        List<Attendance> attendances = attendanceRepository.findByEmployeeEmployeeId(employeeId);
        return attendances.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceDTO createAttendance(AttendanceDTO attendanceDTO) {
        Attendance attendance = convertToEntity(attendanceDTO);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return convertToDTO(savedAttendance);
    }

    @Override
    public AttendanceDTO updateAttendance(int id, AttendanceDTO attendanceDTO) {
        if (!attendanceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Attendance not found with id: " + id);
        }
        Attendance attendance = convertToEntity(attendanceDTO);
        attendance.setAttendanceId(id);
        Attendance updatedAttendance = attendanceRepository.save(attendance);
        return convertToDTO(updatedAttendance);
    }

    @Override
    public void deleteAttendance(int id) {
        if (!attendanceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Attendance not found with id: " + id);
        }
        attendanceRepository.deleteById(id);
    }

    private AttendanceDTO convertToDTO(Attendance attendance) {
        AttendanceDTO dto = modelMapper.map(attendance, AttendanceDTO.class);
        dto.setEmployeeId(attendance.getEmployee().getEmployeeId());
        return dto;
    }

    private Attendance convertToEntity(AttendanceDTO attendanceDTO) {
        Attendance attendance = modelMapper.map(attendanceDTO, Attendance.class);
        
        // Set the employee reference
        if (attendanceDTO.getEmployeeId() > 0) {
            Employee employee = employeeRepository.findById(attendanceDTO.getEmployeeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + attendanceDTO.getEmployeeId()));
            attendance.setEmployee(employee);
        }
        
        return attendance;
    }
}
package com.cts.employee_attendance.service.impl;

import com.cts.employee_attendance.dto.ShiftDTO;
import com.cts.employee_attendance.entity.Employee;
import com.cts.employee_attendance.entity.Shift;
import com.cts.employee_attendance.repository.EmployeeRepository;
import com.cts.employee_attendance.repository.ShiftRepository;
import com.cts.employee_attendance.service.ShiftService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShiftServiceImpl implements ShiftService {

    private final ShiftRepository shiftRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ShiftServiceImpl(ShiftRepository shiftRepository, 
                          EmployeeRepository employeeRepository,
                          ModelMapper modelMapper) {
        this.shiftRepository = shiftRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShiftDTO> getAllShifts() {
        List<Shift> shifts = shiftRepository.findAll();
        return shifts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShiftDTO getShiftById(int id) {
        Shift shift = shiftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shift not found with id: " + id));
        return convertToDTO(shift);
    }

    @Override
    public ShiftDTO getShiftByEmployeeId(int employeeId) {
        List<Shift> shifts = shiftRepository.findByEmployeeEmployeeId(employeeId);
        if (shifts.isEmpty()) {
            throw new RuntimeException("No shift found for employee with id: " + employeeId);
        }
        return convertToDTO(shifts.get(0));
    }

    @Override
    public ShiftDTO createShift(ShiftDTO shiftDTO) {
        Shift shift = convertToEntity(shiftDTO);
        Shift savedShift = shiftRepository.save(shift);
        return convertToDTO(savedShift);
    }

    @Override
    public ShiftDTO updateShift(int id, ShiftDTO shiftDTO) {
        if (!shiftRepository.existsById(id)) {
            throw new RuntimeException("Shift not found with id: " + id);
        }
        Shift shift = convertToEntity(shiftDTO);
        shift.setShiftID(id);
        Shift updatedShift = shiftRepository.save(shift);
        return convertToDTO(updatedShift);
    }

    @Override
    public void deleteShift(int id) {
        if (!shiftRepository.existsById(id)) {
            throw new RuntimeException("Shift not found with id: " + id);
        }
        shiftRepository.deleteById(id);
    }

    private ShiftDTO convertToDTO(Shift shift) {
        ShiftDTO dto = modelMapper.map(shift, ShiftDTO.class);
        if (shift.getEmployee() != null) {
            dto.setEmployeeId(shift.getEmployee().getEmployeeId());
        }
        return dto;
    }

    private Shift convertToEntity(ShiftDTO shiftDTO) {
        Shift shift = modelMapper.map(shiftDTO, Shift.class);
        
        // Set the employee reference
        if (shiftDTO.getEmployeeId() > 0) {
            Employee employee = employeeRepository.findById(shiftDTO.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + shiftDTO.getEmployeeId()));
            shift.setEmployee(employee);
        }
        
        return shift;
    }
}
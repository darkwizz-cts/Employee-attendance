package com.cts.employee_attendance.service.impl;

import com.cts.employee_attendance.dto.LeaveBalanceDTO;
import com.cts.employee_attendance.entity.Employee;
import com.cts.employee_attendance.entity.LeaveBalance;
import com.cts.employee_attendance.repository.EmployeeRepository;
import com.cts.employee_attendance.repository.LeaveBalanceRepository;
import com.cts.employee_attendance.service.LeaveBalanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

    private final LeaveBalanceRepository leaveBalanceRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LeaveBalanceServiceImpl(LeaveBalanceRepository leaveBalanceRepository,
                                 EmployeeRepository employeeRepository,
                                 ModelMapper modelMapper) {
        this.leaveBalanceRepository = leaveBalanceRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LeaveBalanceDTO> getAllLeaveBalances() {
        List<LeaveBalance> leaveBalances = leaveBalanceRepository.findAll();
        return leaveBalances.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveBalanceDTO getLeaveBalanceById(int id) {
        LeaveBalance leaveBalance = leaveBalanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave balance not found with id: " + id));
        return convertToDTO(leaveBalance);
    }

    @Override
    public List<LeaveBalanceDTO> getLeaveBalancesByEmployeeId(int employeeId) {
        List<LeaveBalance> leaveBalances = leaveBalanceRepository.findByEmployeeEmployeeId(employeeId);
        return leaveBalances.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveBalanceDTO createLeaveBalance(LeaveBalanceDTO leaveBalanceDTO) {
        LeaveBalance leaveBalance = convertToEntity(leaveBalanceDTO);
        LeaveBalance savedLeaveBalance = leaveBalanceRepository.save(leaveBalance);
        return convertToDTO(savedLeaveBalance);
    }

    @Override
    public LeaveBalanceDTO updateLeaveBalance(int id, LeaveBalanceDTO leaveBalanceDTO) {
        if (!leaveBalanceRepository.existsById(id)) {
            throw new RuntimeException("Leave balance not found with id: " + id);
        }
        
        LeaveBalance leaveBalance = convertToEntity(leaveBalanceDTO);
        leaveBalance.setLeaveBalanceId(id);
        LeaveBalance updatedLeaveBalance = leaveBalanceRepository.save(leaveBalance);
        return convertToDTO(updatedLeaveBalance);
    }

    @Override
    public void deleteLeaveBalance(int id) {
        if (!leaveBalanceRepository.existsById(id)) {
            throw new RuntimeException("Leave balance not found with id: " + id);
        }
        leaveBalanceRepository.deleteById(id);
    }

    private LeaveBalanceDTO convertToDTO(LeaveBalance leaveBalance) {
        LeaveBalanceDTO dto = modelMapper.map(leaveBalance, LeaveBalanceDTO.class);
        if (leaveBalance.getEmployee() != null) {
            dto.setEmployeeId(leaveBalance.getEmployee().getEmployeeId());
        }
        return dto;
    }

    private LeaveBalance convertToEntity(LeaveBalanceDTO leaveBalanceDTO) {
        LeaveBalance leaveBalance = modelMapper.map(leaveBalanceDTO, LeaveBalance.class);
        
        // Set the employee reference
        if (leaveBalanceDTO.getEmployeeId() > 0) {
            Employee employee = employeeRepository.findById(leaveBalanceDTO.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + leaveBalanceDTO.getEmployeeId()));
            leaveBalance.setEmployee(employee);
        }
        
        return leaveBalance;
    }
}
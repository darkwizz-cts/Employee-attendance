package com.cts.employee_attendance.service.impl;

import com.cts.employee_attendance.dto.LeaveRequestDTO;
import com.cts.employee_attendance.entity.LeaveRequest;
import com.cts.employee_attendance.entity.Employee;
import com.cts.employee_attendance.repository.LeaveRequestRepository;
import com.cts.employee_attendance.repository.EmployeeRepository;
import com.cts.employee_attendance.service.LeaveRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRequestRepository,
                                  EmployeeRepository employeeRepository,
                                  ModelMapper modelMapper) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LeaveRequestDTO> getAllLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findAll();
        return leaveRequests.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveRequestDTO getLeaveRequestById(int id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave request not found with id: " + id));
        return convertToDTO(leaveRequest);
    }

    @Override
    public List<LeaveRequestDTO> getLeaveRequestsByEmployeeId(int employeeId) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByEmployeeEmployeeId(employeeId);
        return leaveRequests.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveRequestDTO createLeaveRequest(LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = convertToEntity(leaveRequestDTO);
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);
        return convertToDTO(savedLeaveRequest);
    }

    @Override
    public LeaveRequestDTO updateLeaveRequest(int id, LeaveRequestDTO leaveRequestDTO) {
        if (!leaveRequestRepository.existsById(id)) {
            throw new RuntimeException("Leave request not found with id: " + id);
        }
        LeaveRequest leaveRequest = convertToEntity(leaveRequestDTO);
        leaveRequest.setLeaveId(id);
        LeaveRequest updatedLeaveRequest = leaveRequestRepository.save(leaveRequest);
        return convertToDTO(updatedLeaveRequest);
    }

    @Override
    public void deleteLeaveRequest(int id) {
        if (!leaveRequestRepository.existsById(id)) {
            throw new RuntimeException("Leave request not found with id: " + id);
        }
        leaveRequestRepository.deleteById(id);
    }

    private LeaveRequestDTO convertToDTO(LeaveRequest leaveRequest) {
        LeaveRequestDTO dto = modelMapper.map(leaveRequest, LeaveRequestDTO.class);
        dto.setEmployeeId(leaveRequest.getEmployee().getEmployeeId());
        return dto;
    }

    private LeaveRequest convertToEntity(LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = modelMapper.map(leaveRequestDTO, LeaveRequest.class);
        
        if (leaveRequestDTO.getEmployeeId() > 0) {
            Employee employee = employeeRepository.findById(leaveRequestDTO.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + leaveRequestDTO.getEmployeeId()));
            leaveRequest.setEmployee(employee);
        }
        
        return leaveRequest;
    }
}
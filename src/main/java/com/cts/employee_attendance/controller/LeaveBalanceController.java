package com.cts.employee_attendance.controller;

import com.cts.employee_attendance.dto.LeaveBalanceDTO;
import com.cts.employee_attendance.service.LeaveBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-balances")
public class LeaveBalanceController {

    private final LeaveBalanceService leaveBalanceService;

    @Autowired
    public LeaveBalanceController(LeaveBalanceService leaveBalanceService) {
        this.leaveBalanceService = leaveBalanceService;
    }

    @GetMapping
    public ResponseEntity<List<LeaveBalanceDTO>> getAllLeaveBalances() {
        List<LeaveBalanceDTO> leaveBalances = leaveBalanceService.getAllLeaveBalances();
        return new ResponseEntity<>(leaveBalances, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveBalanceDTO> getLeaveBalanceById(@PathVariable int id) {
        LeaveBalanceDTO leaveBalance = leaveBalanceService.getLeaveBalanceById(id);
        return new ResponseEntity<>(leaveBalance, HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<LeaveBalanceDTO>> getLeaveBalancesByEmployeeId(@PathVariable int employeeId) {
        List<LeaveBalanceDTO> leaveBalances = leaveBalanceService.getLeaveBalancesByEmployeeId(employeeId);
        return new ResponseEntity<>(leaveBalances, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LeaveBalanceDTO> createLeaveBalance(@RequestBody LeaveBalanceDTO leaveBalanceDTO) {
        LeaveBalanceDTO createdLeaveBalance = leaveBalanceService.createLeaveBalance(leaveBalanceDTO);
        return new ResponseEntity<>(createdLeaveBalance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveBalanceDTO> updateLeaveBalance(@PathVariable int id, @RequestBody LeaveBalanceDTO leaveBalanceDTO) {
        LeaveBalanceDTO updatedLeaveBalance = leaveBalanceService.updateLeaveBalance(id, leaveBalanceDTO);
        return new ResponseEntity<>(updatedLeaveBalance, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaveBalance(@PathVariable int id) {
        leaveBalanceService.deleteLeaveBalance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
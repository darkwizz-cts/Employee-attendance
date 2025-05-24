package com.cts.employee_attendance.controller;

import com.cts.employee_attendance.dto.ShiftDTO;
import com.cts.employee_attendance.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    private final ShiftService shiftService;

    @Autowired
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GetMapping
    public ResponseEntity<List<ShiftDTO>> getAllShifts() {
        List<ShiftDTO> shifts = shiftService.getAllShifts();
        return new ResponseEntity<>(shifts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShiftDTO> getShiftById(@PathVariable int id) {
        ShiftDTO shift = shiftService.getShiftById(id);
        return new ResponseEntity<>(shift, HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<ShiftDTO> getShiftByEmployeeId(@PathVariable int employeeId) {
        ShiftDTO shift = shiftService.getShiftByEmployeeId(employeeId);
        return new ResponseEntity<>(shift, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShiftDTO> createShift(@RequestBody ShiftDTO shiftDTO) {
        ShiftDTO createdShift = shiftService.createShift(shiftDTO);
        return new ResponseEntity<>(createdShift, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShiftDTO> updateShift(@PathVariable int id, @RequestBody ShiftDTO shiftDTO) {
        ShiftDTO updatedShift = shiftService.updateShift(id, shiftDTO);
        return new ResponseEntity<>(updatedShift, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShift(@PathVariable int id) {
        shiftService.deleteShift(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
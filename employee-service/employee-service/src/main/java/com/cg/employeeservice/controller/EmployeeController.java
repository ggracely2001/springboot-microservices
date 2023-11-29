package com.cg.employeeservice.controller;

import com.cg.employeeservice.dto.APIResponseDto;
import com.cg.employeeservice.dto.EmployeeDto;
import com.cg.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
@Tag(
        name = "Employee_Controller",
        description = "Employee_controller Exposes REST API"
)
public class EmployeeController {
    private EmployeeService employeeService;
    @Operation(
            summary = "Save Employee REST API",
            description = "Save is used to save Employee"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    //build save employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedDepartment = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Employee REST API",
            description = "Get is used to get Employee"
    )
    @ApiResponse(
            responseCode = "20",
            description = "OK"
    )
    //build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}

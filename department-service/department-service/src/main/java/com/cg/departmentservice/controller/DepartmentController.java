package com.cg.departmentservice.controller;

import com.cg.departmentservice.dto.DepartmentDto;
import com.cg.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
@Tag(
        name = "Department_Controller",
        description = "Department_controller Exposes REST API"
)

public class DepartmentController {

    private DepartmentService departmentService;
    @Operation(
            summary = "Save Department REST API",
            description = "Save is used to save department"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )

    //build save department rest api
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Department REST API",
            description = "Get is used to get department"
    )
    @ApiResponse(
            responseCode = "20",
            description = "OK"
    )
    //build get department rest api
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}

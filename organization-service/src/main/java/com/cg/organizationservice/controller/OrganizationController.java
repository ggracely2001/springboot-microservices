package com.cg.organizationservice.controller;

import com.cg.organizationservice.dto.OrganizationDto;
import com.cg.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
@Tag(
        name = "Organization_Controller",
        description = "Organization_controller Exposes REST API"
)

public class OrganizationController {

    private OrganizationService organizationService;
    @Operation(
            summary = "Save Organization REST API",
            description = "Save is used to save Organization"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )

    // Build Save Organization REST API
    @PostMapping("create")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Organization REST API",
            description = "Get is used to get Organization"
    )
    @ApiResponse(
            responseCode = "20",
            description = "OK"
    )
    // Build Get Organization by Code REST API
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }

}

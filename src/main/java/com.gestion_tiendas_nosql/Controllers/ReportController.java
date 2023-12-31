package com.gestion_tiendas_nosql.Controllers;

import com.gestion_tiendas_nosql.DTOs.ReportDTO;
import com.gestion_tiendas_nosql.Exceptions.ReportNotFoundException;
import com.gestion_tiendas_nosql.Entities.Report;
import com.gestion_tiendas_nosql.Services.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
@Tag(name="Report Services Controller")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping()
    @Operation(summary = "This method returns a list of the existing reports")
    public ResponseEntity<?> getReports(){
        return ResponseEntity.ok(reportService.getReports());
    }

    @GetMapping("{id}")
    @Operation(summary = "This method returns a report with the specific id")
    public ResponseEntity<?> getReportByID(@PathVariable("id") String id){
        try {
            Report report = reportService.getReportById(id);
            return ResponseEntity.ok(report);
        }catch (ReportNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping()
    @Operation(summary = "This method creates a new report")
    public ResponseEntity<?> createReport(@RequestBody ReportDTO reportCreateRequest){
        return ResponseEntity.ok(reportService.createReport(reportCreateRequest));
    }

    @PutMapping
    @Operation(summary = "This method updates an existing report")
    public ResponseEntity<?> updateReport(@PathVariable("id") String id, @RequestBody ReportDTO reportUpdateRequest) {
        try {
            Report updatedReport = reportService.updateReport(id, reportUpdateRequest);
            return ResponseEntity.ok(updatedReport);
        }catch (ReportNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    @Operation(summary = "This method deletes a report")
    public ResponseEntity<?> deleteReport(@PathVariable("id") String id) {
        try {
            reportService.deleteReport(id);
            return ResponseEntity.ok().build();
        }catch (ReportNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

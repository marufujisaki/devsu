package com.devsu.account.controllers;

import com.devsu.account.dto.ReportDTO;
import com.devsu.account.services.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reportes")
public class ReportController {

    private final ReportService reportService;
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping()
    public ResponseEntity<List<ReportDTO>> report(@RequestParam("fecha") String fecha, @RequestParam("clientId") int clientId) {
        List<ReportDTO> reports = reportService.getClientReport(fecha,clientId);
        return ResponseEntity.ok(reports);
    }
}

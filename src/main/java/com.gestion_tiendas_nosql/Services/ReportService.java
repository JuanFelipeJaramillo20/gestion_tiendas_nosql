package com.gestion_tiendas_nosql.Services;

import com.gestion_tiendas_nosql.DTOs.ReportDTO;
import com.gestion_tiendas_nosql.Exceptions.ReportNotFoundException;
import com.gestion_tiendas_nosql.Entities.Report;
import com.gestion_tiendas_nosql.Repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getReports(){ return reportRepository.findAll(); }

    public Report getReportById(String id){
        Optional<Report> report = reportRepository.findById(id);
        if(report.isPresent()){
            return report.get();
        }else{
            throw new ReportNotFoundException(id);
        }
    }

    public Report createReport(ReportDTO reportDTO){
        Report report = Report
                .builder()
                .date(reportDTO.getDate())
                .productList(reportDTO.getProductList())
                .store(reportDTO.getStore())
                .build();
        return reportRepository.save(report);
    }

    public Report updateReport(String id, ReportDTO reportDTO){
        Optional<Report> optionalReport = reportRepository.findById(id);
        if(optionalReport.isPresent()){
            Report existingReport = optionalReport.get();
            existingReport.setDate(reportDTO.getDate());
            existingReport.setStore(reportDTO.getStore());
            existingReport.setProductList(reportDTO.getProductList());
            return reportRepository.save(existingReport);
        }else{
            throw new ReportNotFoundException(id);
        }
    }

    public boolean deleteReport(String id){
        if(reportRepository.existsById(id)){
            reportRepository.deleteById(id);
            return true;
        }else{
            throw new ReportNotFoundException(id);
        }
    }
}

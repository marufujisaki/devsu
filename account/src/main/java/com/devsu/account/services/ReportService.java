package com.devsu.account.services;

import com.devsu.account.dao.AccountDao;
import com.devsu.account.dao.MovementDao;
import com.devsu.account.dto.AccountDTO;
import com.devsu.account.dto.MovementDTO;
import com.devsu.account.dto.ReportDTO;
import com.devsu.account.entities.Report;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    private final MovementDao movementDao;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat queryFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ReportService(MovementDao movementDao) {
        this.movementDao = movementDao;
    }

    public List<ReportDTO> getClientReport(String dates, int clientId) {
        try {
            String[] date = dates.split("-");
            Date from = sdf.parse(date[0]);
            Date to = sdf.parse(date[1]);
            List<Report> reports = movementDao.getReport(queryFormat.format(from), queryFormat.format(to), clientId);
            if (reports.isEmpty()) {
                return Collections.emptyList();
            }
            return reports.stream().map(r -> new ReportDTO(sdf.format(r.getDate()), r.getClient(),
                    r.getAccountNumber(), r.getAccountType() == AccountDTO.TYPE_AHORRO ? AccountDTO.AHORRO : AccountDTO.CORRIENTE,
                    r.getInitialBalance(), r.isStatus(), r.getMovementType() == MovementDTO.TYPE_WITHDRAW ? r.getAmount() * -1 : r.getAmount(),
                    r.getCurrentBalance())).toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }

    }
}

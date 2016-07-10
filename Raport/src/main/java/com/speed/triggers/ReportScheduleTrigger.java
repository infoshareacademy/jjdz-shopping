package com.speed.triggers;

import com.speed.service.ReportFile;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.io.FileNotFoundException;

@Stateless
public class ReportScheduleTrigger {

    @EJB
    ReportFile reportFile;

    @Schedule(second = "*/20", hour = "*", minute = "*", persistent = false)
    public void run() throws FileNotFoundException {
        reportFile.saveReportToFile();
    }
}

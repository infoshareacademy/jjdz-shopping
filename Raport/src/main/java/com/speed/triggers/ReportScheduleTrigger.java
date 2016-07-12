package com.speed.triggers;

import com.speed.mailservice.SendEmail;
import com.speed.service.ReportFile;
import org.apache.commons.mail.EmailException;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.io.FileNotFoundException;

@Stateless
public class ReportScheduleTrigger {

    @EJB
    ReportFile reportFile;

    @EJB
    SendEmail sendEmail;

    @Schedule(second = "*/60", hour = "*", minute = "*", persistent = false)
    public void run() throws FileNotFoundException, EmailException {
        reportFile.saveReportToFile();
        sendEmail.sendEmail();
    }
}

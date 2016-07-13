package com.speed.triggers;

import com.speed.service.ReportFile;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.io.FileNotFoundException;

@Stateless
public class UserScheduleTrigger {

    @EJB
    ReportFile reportFile;

    @Schedule(second = "*/50", hour = "*", minute = "*", persistent = false)
    public void sendEmailReport() throws FileNotFoundException {
        reportFile.saveUsersToFile();
    }
}

package com.speed.triggers;

import com.speed.model.UsersData;
import com.speed.service.ClientApplication;
import com.speed.mailservice.ReportEmail;
import org.apache.commons.mail.EmailException;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by slawekskel on 7/12/16.
 */
@Stateless
public class SendEmailTrigger {


    @EJB
    ClientApplication clientApplication;

    @Schedule(second = "*/40", hour = "*", minute = "*", persistent = false)
    public void sendEmailReport() throws EmailException {

        ReportEmail reportemail = new ReportEmail();

        List<UsersData> usersData = clientApplication.askForEmails();
        List<String> Adresses = new ArrayList<>();

        for (int i=0; i< usersData.size();i++) {

            Adresses.add(usersData.get(i).getUserEmail());

        }

        reportemail.sendReport("report.txt",Adresses);


    }
}

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

    @Schedule(second = "5", hour = "*", minute = "*/1", persistent = false)
    public void sendEmailReport1() throws EmailException {

        ReportEmail reportemail = new ReportEmail();

        List<UsersData> usersData = clientApplication.askForEmails();
        List<String> Adresses = new ArrayList<>();

        for (int i=0; i< usersData.size();i++) {

            if(usersData.get(i).getReportFrequency().equals("1")) {

                Adresses.add(usersData.get(i).getUserEmail());
            }

        }

       reportemail.sendReport("report.txt",Adresses);
        System.out.println("Sending email 1-->");

    }


    @Schedule(second = "20", hour = "*", minute = "*/2", persistent = false)
    public void sendEmailReport2() throws EmailException {

        ReportEmail reportemail = new ReportEmail();

        List<UsersData> usersData = clientApplication.askForEmails();
        List<String> Adresses = new ArrayList<>();

        for (int i=0; i< usersData.size();i++) {

            if(usersData.get(i).getReportFrequency().equals("2")) {

                Adresses.add(usersData.get(i).getUserEmail());
            }

        }

        reportemail.sendReport("report.txt",Adresses);
        System.out.println("Sending email 2-->");

    }

    @Schedule(second = "35", hour = "*", minute = "*/3", persistent = false)
    public void sendEmailReport3() throws EmailException {

        ReportEmail reportemail = new ReportEmail();

        List<UsersData> usersData = clientApplication.askForEmails();
        List<String> Adresses = new ArrayList<>();

        for (int i=0; i< usersData.size();i++) {

            if(usersData.get(i).getReportFrequency().equals("3")) {

                Adresses.add(usersData.get(i).getUserEmail());
            }

        }

        reportemail.sendReport("report.txt",Adresses);
        System.out.println("Sending email 3-->");

    }


}

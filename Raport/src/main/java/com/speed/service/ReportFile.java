package com.speed.service;

import com.speed.model.ReportDTO;
import com.speed.model.UsersData;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

@Stateless
public class ReportFile {

    @EJB
    ClientApplication clientApplication;

    @EJB
    PopularProductsReport popularProductsReport;

    public void saveUsersToFile() throws FileNotFoundException {
        List<UsersData> usersDataList = clientApplication.askForEmails();
        PrintWriter pw = new PrintWriter(new FileOutputStream("users.txt"));
        for (UsersData line : usersDataList){
            pw.println(line.toString());
        }
        pw.close();
    }

    public void saveReportToFile() throws FileNotFoundException {
        List<ReportDTO> popularProducts = popularProductsReport.getPopularProduct();
        PrintWriter pw = new PrintWriter(new FileOutputStream("report.txt"));
        for (ReportDTO line : popularProducts){
            pw.println(line.toString());
        }
        pw.close();
    }

}

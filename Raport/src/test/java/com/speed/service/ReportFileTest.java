package com.speed.service;

import com.speed.model.ReportDTO;
import com.speed.model.UsersData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


/**
 * Created by ewa on 7/9/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class ReportFileTest {


    @Mock
    PopularProductsReport report;

    @Mock
    ClientApplication clientApplication;

    @InjectMocks
    ReportFile Reportfile;


    @Test
    public void DefinedReportSavedToFile() throws Exception {
//        given
        ReportDTO dto1 = new ReportDTO("rower", 1L);
        ReportDTO dto2 = new ReportDTO("led", 2L);

        List<ReportDTO> ReportDTOs = new ArrayList<>();
        ReportDTOs.add(dto1);
        ReportDTOs.add(dto2);

        List<String> ListFromFile = new ArrayList<>();

//        when
        when(report.getPopularProduct()).thenReturn(ReportDTOs);
        String REPORT_FILE_PATH = "report.txt";
        Reportfile.saveReportToFile();
        File file = new File(REPORT_FILE_PATH);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            ListFromFile.add(line);
        }
        br.close();

//        then
        assertEquals(ReportDTOs.get(0).toString(), ListFromFile.get(0));


    }

    @Test
    public void DefinedUsersSaveToFile() throws Exception {
//        given
        UsersData user1 = new UsersData("user1@email.pl");
        UsersData user2 = new UsersData("user2@email.pl");

        List<UsersData> Users = new ArrayList<>();
        Users.add(user1);
        Users.add(user2);

        List<String> ListFromFile = new ArrayList<>();

//        when
        when(clientApplication.askForEmails()).thenReturn(Users);
        Reportfile.saveUsersToFile();
        String USERS_FILE_PATH = "users.txt";
        File file = new File(USERS_FILE_PATH);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            ListFromFile.add(line);
        }
        br.close();

//        then
        assertEquals(Users.get(0).toString(), ListFromFile.get(0));


    }

}
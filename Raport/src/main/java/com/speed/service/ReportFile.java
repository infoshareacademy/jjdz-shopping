package com.speed.service;

import com.speed.model.ReportDTO;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class ReportFile {

    @Inject
    PopularProductsReport report;



    public void saveToFile() throws FileNotFoundException {
        List<ReportDTO> listToFile = report.getPopularProduct();
        PrintWriter pw = new PrintWriter(new FileOutputStream("test.txt"));
        for (ReportDTO line : listToFile){
            pw.println(line.toString());
        }
        pw.close();
    }

}

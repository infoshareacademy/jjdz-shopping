package com.speed.service;

import com.speed.model.ReportDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by slaw on 23.07.16.
 */
public class ReportParser {

    private List<String> loadedReport;


    public void LoadReportfile() throws IOException {

        List<String> ListFromFile = new ArrayList<>();

        InputStream in = new FileInputStream(new File("report.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            this.loadedReport.add(line);
        }

        reader.close();

    }


}

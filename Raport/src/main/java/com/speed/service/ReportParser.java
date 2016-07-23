package com.speed.service;

import java.io.*;

/**
 * Created by slaw on 23.07.16.
 */
public class ReportParser {

    private String loadedReport;


    public String LoadReportfile() throws IOException {


        InputStream in = new FileInputStream(new File("Report.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }

        System.out.println(out.toString());   //Prints the string content read from input stream
        reader.close();

        return line;

    }


}

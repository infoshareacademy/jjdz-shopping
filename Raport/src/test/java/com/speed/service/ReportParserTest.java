package com.speed.service;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by slaw on 23.07.16.
 */
public class ReportParserTest {




    @Test
    public void ExpectedString() throws IOException {


     ReportParser reportParser = new ReportParser();
     List<String> test;


        test = reportParser.LoadReportfile();



    }




}

package com.speed;

import com.speed.service.ReportFile;

import java.io.FileNotFoundException;

public class App {

    public static void main(String args[]) throws FileNotFoundException {
        ReportFile rf = new ReportFile();
        rf.saveToFile();
    }

}

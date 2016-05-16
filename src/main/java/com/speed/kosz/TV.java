package com.speed.kosz;

import java.util.HashMap;

/**
 * Created by slawekskel on 2/25/16.
 */

//Klasa bazowa telewizora
public class TV {


    //własności podstawowe dla wszystkich telewizorów//---------------------------
    private double cena;     //kwota zł (max/min)
    private boolean nowy;                //nowe/uzywane /true/false
    private HashMap<String, Integer> format;   //4:3/16:9/Inny
    private Integer ID;
    //---------------------------------------------------



    //Konstruktor domyślny bez parametrów
    public TV() {
        this.cena = 0;
        this.nowy = false;
        this.ID = 1;

        this.format = new HashMap<>();
        this.format.put("4:3",0);
        this.format.put("16:9",0);
        this.format.put("Inny",0);
    }

    //Konstuktor przyjmujacy gotowa HashMape formatów
    public TV(double cena, boolean nowy, HashMap<String, Integer> format, Integer ID) {
        this.cena = cena;
        this.nowy = nowy;
        this.format = format;
        this.ID = ID;
    }

    //Konstuktor ustawiający wszystkie parametry
    public TV(double cena, boolean nowy, String keyFormat, Integer valueFormat) {
        this.cena = cena;
        this.nowy = nowy;
        this.format = new HashMap<String, Integer>();       //stworzenie hashmapy formatu
        this.format.put(keyFormat,valueFormat);             //przypisanie zadanych wartości
    }

    //standardowe gety/sety


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }


    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }

    public HashMap<String, Integer> getFormat() {
        return format;
    }

    public void setFormat(HashMap<String, Integer> format) {
        this.format = format;
    }

    //Indywidualne
    public void setFormat(String key, Integer value) {
        this.format.put(key, value);

    }



}

//Klasa rozszeżająca do LCD
class LCD extends TV {


    //wławności dla LCD//---------------------------
    private HashMap<String, Integer> odswiezanie; //50/100/200 Hz
    private HashMap<String, Integer> TunerDVBT; //MPEG-2/4/brak
    private HashMap<String, Integer> zlacza;       //Kompozyt/Euro/S-Video/Component/HDMI/DVI/D-SUB/USB

    private int przekatna;               //cale (max/min)

    private  boolean fullHD;              //tak/nie
    private  boolean podswietlenieLED;    //tak/nie
    private  boolean is3D;                // tak/nie
    private  double jasnosc;      //cd/m2 (max/min)
    private  double kontrast;     //x:1 (max/min)

    private Integer ID;
    //---------------------------------------------------




    public LCD() {

        this.ID = 2;
        this.odswiezanie = new HashMap<String, Integer>();
        this.TunerDVBT = new HashMap<String, Integer>();
        this.zlacza = new HashMap<String, Integer>();

        this.odswiezanie.put("50Hz",0);
        this.odswiezanie.put("100Hz",0);
        this.odswiezanie.put("200Hz",0);

        this.TunerDVBT.put("MPEG-2",0);
        this.TunerDVBT.put("MPEG-4",0);
        this.TunerDVBT.put("BRAK",1);

        this.zlacza.put("Kompozyt",0);
        this.zlacza.put("Euro",0);
        this.zlacza.put("S-Video",0);
        this.zlacza.put("Component",0);
        this.zlacza.put("HDMI",0);
        this.zlacza.put("DVI",0);
        this.zlacza.put("D-SUB",0);
        this.zlacza.put("USB",0);

    }


    //standardowe gety/sety

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public double getKontrast() {
        return kontrast;
    }

    public void setKontrast(double kontrast) {
        this.kontrast = kontrast;
    }

    public HashMap<String, Integer> getOdswiezanie() {
        return odswiezanie;
    }

    public void setOdswiezanie(HashMap<String, Integer> odswiezanie) {
        this.odswiezanie = odswiezanie;
    }

    public HashMap<String, Integer> getTunerDVBT() {
        return TunerDVBT;
    }

    public void setTunerDVBT(HashMap<String, Integer> tunerDVBT) {
        TunerDVBT = tunerDVBT;
    }

    public HashMap<String, Integer> getZlacza() {
        return zlacza;
    }

    public void setZlacza(HashMap<String, Integer> zlacza) {
        this.zlacza = zlacza;
    }

    public int getPrzekatna() {
        return przekatna;
    }

    public void setPrzekatna(int przekatna) {
        this.przekatna = przekatna;
    }

    public boolean isFullHD() {
        return fullHD;
    }

    public void setFullHD(boolean fullHD) {
        this.fullHD = fullHD;
    }

    public boolean isPodswietlenieLED() {
        return podswietlenieLED;
    }

    public void setPodswietlenieLED(boolean podswietlenieLED) {
        this.podswietlenieLED = podswietlenieLED;
    }

    public boolean is3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public double getJasnosc() {
        return jasnosc;
    }

    public void setJasnosc(double jasnosc) {
        this.jasnosc = jasnosc;
    }

    //Indywidualne
    public void setOdswiezanie(String key, Integer value) {
        this.odswiezanie.put(key, value);
    }

    public void setTunerDVBT(String key, Integer value) {
        this.TunerDVBT.put(key, value);
    }
    public void setZlacza(String key, Integer value) {
        this.zlacza.put(key, value);
    }



}

class Plazma extends TV {


    //wławności dla Plazma//---------------------------
    private HashMap<String, Integer> TunerDVBT; //MPEG-2/4/brak
    private HashMap<String, Integer> zlacza;       //Kompozyt/Euro/S-Video/Component/HDMI/DVI/D-SUB/USB

    private  int przekatna;               //cale (max/min)
    private  boolean fullHD;              //tak/nie
    private  double jasnosc;      //cd/m2 (max/min)
    private  double kontrast;     //x:1 (max/min)

    private Integer ID;
    //---------------------------------------------------


    public Plazma() {

        this.TunerDVBT = new HashMap<String, Integer>();
        this.zlacza = new HashMap<String, Integer>();

        this.TunerDVBT.put("MPEG-2",0);
        this.TunerDVBT.put("MPEG-4",0);
        this.TunerDVBT.put("BRAK",1);

        this.zlacza.put("Kompozyt",0);
        this.zlacza.put("Euro",0);
        this.zlacza.put("S-Video",0);
        this.zlacza.put("Component",0);
        this.zlacza.put("HDMI",0);
        this.zlacza.put("DVI",0);
        this.zlacza.put("D-SUB",0);
        this.zlacza.put("USB",0);
        this.ID = 3;

    }


    //standardowe gety/sety
    public HashMap<String, Integer> getTunerDVBT() {
        return TunerDVBT;
    }

    public void setTunerDVBT(HashMap<String, Integer> tunerDVBT) {
        TunerDVBT = tunerDVBT;
    }

    public HashMap<String, Integer> getZlacza() {
        return zlacza;
    }

    public void setZlacza(HashMap<String, Integer> zlacza) {
        this.zlacza = zlacza;
    }

    public int getPrzekatna() {
        return przekatna;
    }

    public void setPrzekatna(int przekatna) {
        this.przekatna = przekatna;
    }

    public boolean isFullHD() {
        return fullHD;
    }

    public void setFullHD(boolean fullHD) {
        this.fullHD = fullHD;
    }

    public double getJasnosc() {
        return jasnosc;
    }

    public void setJasnosc(double jasnosc) {
        this.jasnosc = jasnosc;
    }

    public double getKontrast() {
        return kontrast;
    }

    public void setKontrast(double kontrast) {
        this.kontrast = kontrast;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    //Indywidualne
    public void setTunerDVBT(String key, Integer value) {
        this.TunerDVBT.put(key, value);
    }
    public void setZlacza(String key, Integer value) {
        this.zlacza.put(key, value);
    }


}

class Kineskop extends TV {

    //wławności dla Kineskop//---------------------------
    private HashMap<String, Integer> odswiezanie; //50/100/200 Hz

    private Integer ID;
    //---------------------------------------------------

    public Kineskop() {

        this.odswiezanie = new HashMap<String, Integer>();

        this.odswiezanie.put("50Hz",0);
        this.odswiezanie.put("100Hz",0);
        this.odswiezanie.put("200Hz",0);

        this.ID = 4;
    }



    public HashMap<String, Integer> getOdswiezanie() {
        return odswiezanie;
    }

    public void setOdswiezanie(HashMap<String, Integer> odswiezanie) {
        this.odswiezanie = odswiezanie;
    }

    //Indywidualne
    public void setOdswiezanie(String key, Integer value) {
        this.odswiezanie.put(key, value);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
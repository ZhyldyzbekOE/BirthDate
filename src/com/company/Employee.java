package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private Date birthDate;
    private String name;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat dayMon = new SimpleDateFormat("dd.MM");

    public Employee(String birthDate, String name) {

        try {
            this.birthDate = sdf.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.name = name;
    }
    public SimpleDateFormat getDayMon() {
        return dayMon;
    }

    public void setDayMon(SimpleDateFormat dayMon) {
        this.dayMon = dayMon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

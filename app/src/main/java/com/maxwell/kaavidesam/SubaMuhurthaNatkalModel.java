package com.maxwell.kaavidesam;

public class SubaMuhurthaNatkalModel {
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTamilDate() {
        return tamilDate;
    }

    public void setTamilDate(String tamilDate) {
        this.tamilDate = tamilDate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTamilMonth() {
        return tamilMonth;
    }

    public void setTamilMonth(String tamilMonth) {
        this.tamilMonth = tamilMonth;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    String date;
    String tamilDate;
    String day;
    String tamilMonth;
    String month;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    String information;
    String fromTime;
    String toTime;

}

package com.example.yash.finalone;

public class Data {
    private String name;
    private String address;
    private  String mob;
    private String vehNo;
    private String batteryNo;
    private String amt;
    private String date;
    private String batteryType;
    private String batteryWarrenty;

    public void setBatteryWarrenty(String batteryWarrenty) {
        this.batteryWarrenty = batteryWarrenty;
    }

    public String getBatteryWarrenty() {

        return batteryWarrenty;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMob() {
        return mob;
    }

    public String getVehNo() {
        return vehNo;
    }

    public String getBatteryNo() {
        return batteryNo;
    }
    public String getBatteryType() {
        return batteryType;
    }

    public String getAmt() {
        return amt;
    }
    public String getDate() {
        return date;
    }
    public Data()
    {}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public void setVehNo(String vehNo) {
        this.vehNo = vehNo;
    }

    public void setBatteryNo(String batteryNo) {
        this.batteryNo = batteryNo;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }
    public Data(String name, String address, String mob, String vehNo, String batteryNo, String amt,String date,String batteryType,String batteryWarrenty) {

        this.name = name;
        this.address = address;
        this.mob = mob;
        this.vehNo = vehNo;
        this.batteryNo = batteryNo;
        this.amt = amt;
        this.date=date;
        this.batteryType=batteryType;
        this.batteryWarrenty=batteryWarrenty;
    }
}

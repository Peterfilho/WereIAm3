package com.example.wereiam3;

public class Access_point {

    int id;
    String name;
    String ap1;
    String ap2;
    String ap3;
    String ap4;
    String ap5;

    public Access_point() {

    }

    public Access_point(int id, String name, String ap1,String ap2, String ap3, String ap4, String ap5) {
        this.id = id;
        this.name = name;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.ap3 = ap3;
        this.ap4 = ap4;
        this.ap5 = ap5;
    }

    public Access_point(String name, String ap1, String ap2, String ap3, String ap4, String ap5) {
        this.name = name;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.ap3 = ap3;
        this.ap4 = ap4;
        this.ap5 = ap5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAp1() {
        return ap1;
    }

    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public void setAp2(String ap2) {
        this.ap2 = ap2;
    }

    public String getAp3() {
        return ap3;
    }

    public void setAp3(String ap3) {
        this.ap3 = ap3;
    }

    public String getAp4() {
        return ap4;
    }

    public void setAp4(String ap4) {
        this.ap4 = ap4;
    }

    public String getAp5() {
        return ap5;
    }

    public void setAp5(String ap5) {
        this.ap5 = ap5;
    }
}

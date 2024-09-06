package com.example.zambeeladmin;

import java.io.Serializable;

public class DataClass implements Serializable {
    private String dataname;
    private String dataphonenumber;
    private String dataaddres;
    private String dataopentime;
    private String dataclosetime;
    private String datasector;
    //sector ke jaga kahi hm ny services le hai form ma but yaha sector he use howa hai werna dataclass sb ke alg bna na thui
    private String datalocation;
    private String dataImage;
    private String id;
    private float rating;

    public float getRating() {
        return rating;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataClass(String dataname, String dataphonenumber, String dataaddres, String dataopentime, String dataclosetime, String datasector, String datalocation, String dataImage,float rating) {
        this.dataname = dataname;
        this.dataphonenumber = dataphonenumber;
        this.dataaddres = dataaddres;
        this.dataopentime = dataopentime;
        this.dataclosetime = dataclosetime;
        this.datasector = datasector;
        this.datalocation = datalocation;
        this.dataImage = dataImage;
        this.rating=rating;
    }

    public String getDataname() {
        return dataname;
    }

    public String getDataphonenumber() {
        return dataphonenumber;
    }

    public String getDataaddres() {
        return dataaddres;
    }

    public String getDataopentime() {
        return dataopentime;
    }

    public String getDataclosetime() {
        return dataclosetime;
    }

    public String getDatasector() {
        return datasector;
    }

    public String getDatalocation() {
        return datalocation;
    }

    public String getDataImage() {
        return dataImage;
    }

    public  DataClass(){

    }
}

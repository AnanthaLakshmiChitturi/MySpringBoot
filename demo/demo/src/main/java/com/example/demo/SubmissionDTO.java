package com.example.demo;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class SubmissionDTO {
    public SubmissionDTO(String name, String vendorName, int rate, String leadName, String technology) {
        this.Name=name;
        this.rate=rate;
        this.leadName=leadName;
        this.setTechnology(technology);
        this.setVendorName(vendorName);

    }
    public SubmissionDTO(){

    }


    public void setName(String name) {
        Name = name;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public void setTechnology(String technology) {
        Technology = technology;
    }

    public String Name;

    @JsonIgnore

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String Id;
    public String VendorName;
    public int rate;
    public String leadName;
    public String Technology;



}

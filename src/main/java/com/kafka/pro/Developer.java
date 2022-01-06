package com.kafka.pro;

public class Developer {
    String Name;
    String Designation;
    String Company;
    int Id;

    public Developer(String Name, String Designation, String Company) {
        this.Name = Name;
        this.Designation = Designation;
        this.Company = Company;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {

        Name = name;
    }

    public String getDesignation() {

        return Designation;
    }

    public void setDesignation(String designation) {

        Designation = designation;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {

        Company = company;
    }

    @Override
    public String toString() {
        String str = "Developer:[name=" + getName() + ",company=" + getCompany() + ",Designation=" + getDesignation() + "]";
        return str;

    }
}
/*
    public static void main(String args[]){
        Developer dev=new Developer();
        dev.setName("krish");
        dev.setDesignation("Techie");
        dev.setCompany("KMC");
        dev.setId(18);
        System.out.println(dev.toString());
    }
}*/
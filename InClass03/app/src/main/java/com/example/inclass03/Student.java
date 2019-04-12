package com.example.inclass03;

import java.io.Serializable;

public class Student implements Serializable {
    String fname,lname,dept,s_id, avatar;


    public Student(String fname, String lname, String dept, String s_id, String avatar) {
        this.fname = fname;
        this.lname = lname;
        this.dept = dept;
        this.s_id = s_id;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", dept='" + dept + '\'' +
                ", s_id='" + s_id + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public String getFullName(){
        return (fname + " " + lname);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

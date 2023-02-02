package com.rmn.getapi.model;
import com.google.gson.annotations.SerializedName;

public class Subject {
    @SerializedName("subject_id")
    private int subject_id;
    @SerializedName("subject_name")
    private String subject_name;
    @SerializedName("sks")
    private int sks;

    public Subject() {
    }
    public Subject(int subject_id, String subject_name, int sks) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.sks = sks;
    }
    public int getSubject_id() {
        return subject_id;
    }
    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
    public String getSubject_name() {
        return subject_name;
    }
    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
    public int getSks() {
        return sks;
    }
    public void setSks(int sks) {
        this.sks = sks;
    }
}
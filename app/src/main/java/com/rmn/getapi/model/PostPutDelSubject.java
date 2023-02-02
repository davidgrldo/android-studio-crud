package com.rmn.getapi.model;
import com.google.gson.annotations.SerializedName;
public class PostPutDelSubject {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Subject mSubject;
    @SerializedName("message")
    String message;
}

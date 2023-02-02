package com.rmn.getapi.rest;
import com.rmn.getapi.model.PostPutDelSubject;
import com.rmn.getapi.model.Subject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("subjects")
    Call<List<Subject>> getSubject();
    @FormUrlEncoded
    @POST("subjects")
    Call<PostPutDelSubject> postSubject(@Field("name") String name,
                                      @Field("sks") int sks);
    @FormUrlEncoded
    @PUT("subject/{id}")
    Call<PostPutDelSubject> putSubject(@Path("id") int id,
                                     @Field("subject_name") String subject_name,
                                     @Field("sks") int sks);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "subject/{id}", hasBody = true)
    Call<PostPutDelSubject> deleteSubject(@Path("id") int id, @Field("subject_id") int subject_id);
}

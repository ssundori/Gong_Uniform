package com.example.gongu.retrofit;

import com.example.gongu.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
public interface UserAPI {
    @GET("/user")
    Call<List<User>> getAll();

    @POST("/user")
    Call<User> get(@Body User user);
}

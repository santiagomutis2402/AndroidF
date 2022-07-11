package com.example.loginfiina.login.Interface;

import com.example.loginfiina.login.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Posts>> getPosts();


}

package com.example.loginfiina.Services;

import retrofit2.Call;

import com.example.loginfiina.Entidades.DatosUsuarios;
import com.example.loginfiina.Request.UsuarioRequest;
import com.example.loginfiina.Response.UsuarioResponse;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("login")
    Call<UsuarioResponse> login(@Body UsuarioRequest request);

    @POST("usuarios")
    Call<Integer> postRegistrarUsuarios(@Body DatosUsuarios estudiante);
    @POST("datos_usuarios")
    Call<Integer> postRegistrarDatosUsuarios(@Body DatosUsuarios estudiante);

}

package com.edu.ifsp.fabio.xptosa.service;

import com.edu.ifsp.fabio.xptosa.domain.Departamento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DepartamentoService {
    @GET("departamento/list")
    Call<List<Departamento>> listarDepartamentos();

    @POST("departamento/new")
    Call<Departamento> criarDepartamento(@Body Departamento departamento);
}

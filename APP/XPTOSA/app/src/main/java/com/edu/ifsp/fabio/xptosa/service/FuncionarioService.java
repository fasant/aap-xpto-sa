package com.edu.ifsp.fabio.xptosa.service;


import com.edu.ifsp.fabio.xptosa.domain.Funcionario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FuncionarioService{
    @GET("funcionario/list")
    Call<List<Funcionario>> listarFuncionarios();

    @POST("funcionario/new")
    Call<Funcionario> criarFuncionario(@Body Funcionario funcionario);
}

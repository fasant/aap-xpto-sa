package com.edu.ifsp.fabio.xptosa.presenter;

import android.content.Context;
import android.widget.ListView;

import com.edu.ifsp.fabio.xptosa.adapter.FuncionarioAdapter;
import com.edu.ifsp.fabio.xptosa.domain.Funcionario;
import com.edu.ifsp.fabio.xptosa.service.FuncionarioService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fabio on 03/06/2016.
 */
public class ListarFuncionariosPresenter {

    public static String baseURL = "http://192.168.1.47:9090/";

    public void listarFuncionarios(final Context context, final ListView listView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FuncionarioService service = retrofit.create(FuncionarioService.class);
        Call<List<Funcionario>> call = service.listarFuncionarios();

        call.enqueue(new Callback<List<Funcionario>>() {
            @Override
            public void onResponse(Call<List<Funcionario>> call, Response<List<Funcionario>> response) {
                List<Funcionario> list = response.body();

                listView.setAdapter(new FuncionarioAdapter(context, list));
            }

            @Override
            public void onFailure(Call<List<Funcionario>> call, Throwable t) {

            }
        });
    }

}

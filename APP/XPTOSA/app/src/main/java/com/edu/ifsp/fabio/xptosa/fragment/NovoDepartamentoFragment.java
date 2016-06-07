package com.edu.ifsp.fabio.xptosa.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.edu.ifsp.fabio.xptosa.R;
import com.edu.ifsp.fabio.xptosa.domain.Departamento;
import com.edu.ifsp.fabio.xptosa.service.DepartamentoService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NovoDepartamentoFragment extends Fragment {
    private Context context;
    public NovoDepartamentoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo_departamento, container, false);

        Button btGravarDepartamento = (Button) view.findViewById(R.id.btGravarDepartamento);
        btGravarDepartamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarDepartamento();
            }
        });

        context = container.getContext();

        return view;
    }

    private void gravarDepartamento() {

        String baseURL = "http://192.168.1.47:9090/";

        EditText eNumero   = (EditText) getView().findViewById(R.id.eNumero);
        EditText eNome     = (EditText) getView().findViewById(R.id.eNome);
        EditText eLocal    = (EditText) getView().findViewById(R.id.eLocal);

        Departamento departamento = new Departamento();
        departamento.setId(Long.parseLong(eNumero.getText().toString()));
        departamento.setNome(eNome.getText().toString());
        departamento.setLocal(eLocal.getText().toString());

        eNumero.setText("");
        eNome.setText("");
        eLocal.setText("");

//Debug
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        DepartamentoService service = retrofit.create(DepartamentoService.class);

        Call<Departamento> call = service.criarDepartamento(departamento);

        call.enqueue(new Callback<Departamento>() {
            @Override
            public void onResponse(Call<Departamento> call, Response<Departamento> response){
            }

            @Override
            public void onFailure(Call<Departamento> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

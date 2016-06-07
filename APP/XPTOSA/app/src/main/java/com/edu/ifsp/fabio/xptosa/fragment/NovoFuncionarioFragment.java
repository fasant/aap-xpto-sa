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
import com.edu.ifsp.fabio.xptosa.domain.Funcionario;
import com.edu.ifsp.fabio.xptosa.service.FuncionarioService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NovoFuncionarioFragment extends Fragment {
    private Context context;
    public NovoFuncionarioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo_funcionario, container, false);

        Button btGravarFuncionario = (Button) view.findViewById(R.id.btGravarFuncionario);
        btGravarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravarFuncionario();
            }
        });

        context = container.getContext();

        return view;
    }

    private void gravarFuncionario() {

        String baseURL = "http://192.168.1.47:9090/";

        EditText eNumero   = (EditText) getView().findViewById(R.id.eNumeroFuncionario);
        EditText eNome     = (EditText) getView().findViewById(R.id.eNomeFuncionario);
        EditText eCargo    = (EditText) getView().findViewById(R.id.eCargo);
        EditText eSal      = (EditText) getView().findViewById(R.id.eSal);

        Funcionario funcionario = new Funcionario();
        funcionario.setId(Long.parseLong(eNumero.getText().toString()));
        funcionario.setNome(eNome.getText().toString());
        funcionario.setCargo(eCargo.getText().toString());
        funcionario.setSal(Double.parseDouble(eSal.getText().toString()));


        eNumero.setText("");
        eNome.setText("");
        eCargo.setText("");
        eSal.setText("");

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

        FuncionarioService service = retrofit.create(FuncionarioService.class);

        Call<Funcionario> call = service.criarFuncionario(funcionario);

        call.enqueue(new Callback<Funcionario>() {
            @Override
            public void onResponse(Call<Funcionario> call, Response<Funcionario> response){
            }

            @Override
            public void onFailure(Call<Funcionario> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

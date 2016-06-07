package com.edu.ifsp.fabio.xptosa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.edu.ifsp.fabio.xptosa.R;
import com.edu.ifsp.fabio.xptosa.domain.Funcionario;

import java.util.List;

/**
 * Created by Fabio on 03/06/2016.
 */
public class FuncionarioAdapter extends BaseAdapter {
    private final Context context;
    private final List<Funcionario> funcionarios;

    public FuncionarioAdapter(Context context, List<Funcionario> funcionarios) {
        this.context = context;
        this.funcionarios = funcionarios;
    }


    @Override
    public int getCount() {
        return funcionarios != null ? funcionarios.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return funcionarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return funcionarios.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_funcionario, parent, false);

        TextView tNome = (TextView) view.findViewById(R.id.tNomeFuncionario);
        TextView tCargo = (TextView) view.findViewById(R.id.tCargo);
        TextView tSal = (TextView) view.findViewById(R.id.tSal);

        Funcionario funcionario = funcionarios.get(position);
        tNome.setText(funcionario.getNome());
        tCargo.setText(funcionario.getCargo());
        tSal.setText(Double.toString(funcionario.getSal()));

        return view;
    }
}
